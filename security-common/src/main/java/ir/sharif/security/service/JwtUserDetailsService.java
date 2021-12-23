package ir.sharif.security.service;


import ir.sharif.entity.UserEntity;
import ir.sharif.security.Repository.UserSecurityRepository;
import ir.sharif.security.model.Authority;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserSecurityRepository userSecurityRepository;

    @Value("${security.admin.password}")
    private String adminPassword;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equals(username)) {
            return new User("admin", passwordEncoder.encode(adminPassword),
                Collections.singleton(Authority.ADMIN));
        } else {
            Optional<UserEntity> id = userSecurityRepository.findById(username);
            if (id.isEmpty()) {
                throw new UsernameNotFoundException("User not found with username: " + username);
            }
            UserEntity userEntity = id.get();
            ArrayList<Authority> authorities = new ArrayList<>();
            if (userEntity.isDoctor()) {
                authorities.add(Authority.DOCTOR);
            }
            if (userEntity.isPatient()) {
                authorities.add(Authority.PATIENT);
            }
            return new User(username, userEntity.getPasswordHash(), authorities);
        }
    }

}