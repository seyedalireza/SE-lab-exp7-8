package ir.sharif.personrepository;

import ir.sharif.entity.dto.Doctor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {


    @GetMapping("/signup")
    public void signUp(Doctor doctor) {

    }

    @GetMapping("/profile")
    public Doctor getProfile() {
        // Get username from request auth headers
        return null;
    }
}
