package ir.sharif.admin;

import ir.sharif.entity.UserEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@Secured("ADMIN")
public class AdminController {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/status")
    public Status getStatus() {
        List<UserEntity> allUsers = userRepository.findAll();
        int numberOfUsers = allUsers.size();
        long numberOfDoctors = allUsers.stream().filter(UserEntity::isDoctor).count();
        long numberOfPatients = allUsers.stream().filter(UserEntity::isPatient).count();
        int numberOfPrescriptions = prescriptionRepository.findAll().size();
        return new Status()
            .setNumberOfUsers(numberOfUsers)
            .setNumberOfPatients(numberOfPatients)
            .setNumberOfDoctors(numberOfDoctors)
            .setNumberOfPrescriptions(numberOfPrescriptions);
    }
}
