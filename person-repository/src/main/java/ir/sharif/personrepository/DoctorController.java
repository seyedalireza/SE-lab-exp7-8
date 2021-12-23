package ir.sharif.personrepository;

import ir.sharif.entity.PrescriptionEntity;
import ir.sharif.entity.UserEntity;
import ir.sharif.entity.dto.Doctor;
import ir.sharif.personrepository.model.InsertPrescriptionRequest;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/signup")
    public void signUp(@RequestBody Doctor doctor) {
        if (doctor.getUsername() == null || doctor.getUsername().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username should not be empty.");
        }
        UserEntity userEntity = new UserEntity()
            .setDoctor(true)
            .setUsername(doctor.getUsername())
            .setName(doctor.getName())
            .setNationalCode(doctor.getNationalCode())
            .setPasswordHash(passwordEncoder.encode(doctor.getPassword()));
        userRepository.save(userEntity);

    }

    @GetMapping("/profile")
    @Secured("DOCTOR")
    public Doctor getProfile(@ApiIgnore @AuthenticationPrincipal User user) {
        UserEntity userEntity = getUser(user.getUsername());
        return new Doctor()
            .setName(userEntity.getName())
            .setNationalCode(userEntity.getNationalCode())
            .setUsername(userEntity.getUsername());
    }

    private UserEntity getUser(String username) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(username);
        if (userEntityOptional.isEmpty()) {
            throw new AssertionError("Authorization is not working!");
        }
        UserEntity userEntity = userEntityOptional.get();
        return userEntity;
    }

    @PostMapping("/prescription")
    @Secured("DOCTOR")
    public void addPrescription(@ApiIgnore @AuthenticationPrincipal User user, @RequestBody InsertPrescriptionRequest request) {
        UserEntity doctor = getUser(user.getUsername());
        UserEntity patient = getUser(request.getPatientUsername());

        PrescriptionEntity prescriptionEntity = new PrescriptionEntity()
            .setComment(request.getComment())
            .setMedicines(request.getMedicines())
            .setDoctorEntity(doctor)
            .setPatientEntity(patient);
        prescriptionRepository.save(prescriptionEntity);
    }
}
