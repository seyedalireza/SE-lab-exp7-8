package ir.sharif.personrepository;

import ir.sharif.entity.PrescriptionEntity;
import ir.sharif.entity.UserEntity;
import ir.sharif.entity.dto.Doctor;
import ir.sharif.entity.dto.Patient;
import ir.sharif.entity.dto.Prescription;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/signup")
    public void signUp(@RequestBody Doctor doctor) {
        if (doctor.getUsername() == null || doctor.getUsername().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username should not be empty.");
        }
        UserEntity userEntity = new UserEntity()
            .setPatient(true)
            .setUsername(doctor.getUsername())
            .setName(doctor.getName())
            .setNationalCode(doctor.getNationalCode())
            .setPasswordHash(passwordEncoder.encode(doctor.getPassword()));
        userRepository.save(userEntity);
    }

    @GetMapping("/profile")
    @Secured("PATIENT")
    public Patient getProfile(@AuthenticationPrincipal User user) {
        String username = user.getUsername();
        Optional<UserEntity> userEntityOptional = userRepository.findById(username);
        if (userEntityOptional.isEmpty()) {
            throw new AssertionError("Authorization is not working!");
        }
        UserEntity userEntity = userEntityOptional.get();
        return new Patient()
            .setName(userEntity.getName())
            .setNationalCode(userEntity.getNationalCode())
            .setUsername(userEntity.getUsername());
    }

    @GetMapping("/prescription")
    @Secured("PATIENT")
    public List<Prescription> getAllPrescription(@AuthenticationPrincipal User user) {
        String username = user.getUsername();
        Optional<UserEntity> userEntityOptional = userRepository.findById(username);
        if (userEntityOptional.isEmpty()) {
            throw new AssertionError("Authorization is not working!");
        }
        UserEntity userEntity = userEntityOptional.get();
        List<PrescriptionEntity> prescriptionEntities = prescriptionRepository
            .findAll(Example.of(new PrescriptionEntity().setPatientEntity(userEntity)));

        return prescriptionEntities.stream()
            .map(p -> new Prescription().setComment(p.getComment())
                .setDoctor(toDoctor(p.getDoctorEntity())).setId(p.getId()).setMedicines(p.getMedicines()))
            .collect(Collectors.toList());
    }

    private static Doctor toDoctor(UserEntity userEntity) {
        return new Doctor()
            .setUsername(userEntity.getUsername())
            .setNationalCode(userEntity.getNationalCode())
            .setName(userEntity.getName());
    }
}
