package edu.miu.util;

import edu.miu.entity.Role;
import edu.miu.entity.User;
import edu.miu.jwt.RoleName;
import edu.miu.repository.RoleRepository;
import edu.miu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        preloadRoles();
        initializeUser();
    }


    private void preloadRoles() {
        if (roleRepository.findAll().size() == 0) {
            roleRepository.save(new Role(RoleName.ROLE_ADMIN));
            roleRepository.save(new Role(RoleName.ROLE_USER));
        }
    }

    private void initializeUser() {
        Role role = roleRepository.findByName(RoleName.ROLE_USER).orElse(null);
        if (role != null) {
            User user = new User("example@gmail.com", passwordEncoder.encode("12345"), "John", "Doe");
            user.setRoles(Collections.singletonList(role));
            userRepository.save(user);
            System.out.println("---- USER CREATED----\n");
            System.out.println("Email: example@gmail.com, Password: 12345");
        }
    }
}