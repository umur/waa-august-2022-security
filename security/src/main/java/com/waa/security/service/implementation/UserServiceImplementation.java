package com.waa.security.service.implementation;

import com.waa.security.dto.RegisterRequest;
import com.waa.security.entity.Role;
import com.waa.security.entity.User;
import com.waa.security.repository.RoleRepository;
import com.waa.security.repository.UserRepository;
import com.waa.security.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String email) {
        return userRepository.findByUsername(email);
    }

    @Override
    public User signup(RegisterRequest registerRequest) throws Exception {
        if (userRepository.existsByUsername(registerRequest.getUsername())) {
            throw new Exception("Email Already exists!");
        }
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        Role role = roleRepository.findByName("ROLE_CLIENT").get();
        user.setRoles(Collections.singleton(role));
        return userRepository.save(user);
    }
}
