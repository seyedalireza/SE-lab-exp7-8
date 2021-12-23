package ir.sharif.personrepository;

import ir.sharif.entity.UserEntity;
import ir.sharif.entity.dto.Doctor;
import ir.sharif.entity.dto.Patient;
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

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private UserRepository userRepository;

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
}
