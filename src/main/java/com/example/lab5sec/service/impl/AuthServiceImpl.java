package com.example.lab5sec.service.impl;

import com.example.lab5sec.entity.Role;
import com.example.lab5sec.entity.User;
import com.example.lab5sec.model.LoginRequest;
import com.example.lab5sec.model.LoginResponse;
import com.example.lab5sec.model.SignupRequest;
import com.example.lab5sec.repo.RoleRepo;
import com.example.lab5sec.repo.UserRepo;
import com.example.lab5sec.security.JwtHelper;
import com.example.lab5sec.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
//@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    @Autowired
    private  AuthenticationManager authenticationManager;
    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncode;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        log.info("coming");
        try {
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword() )
            );
            log.info("==> "+result);
        }
        catch (BadCredentialsException e) {
            log.info("Bad Credentials");
        }
        final String accessToken = jwtHelper.generateToken(loginRequest.getEmail());
        //final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new LoginResponse(accessToken);
        return loginResponse;
    }


    public User signup(SignupRequest signupRequest){

        User newUser = new User();
        newUser.setName(signupRequest.getName());
        newUser.setEmail(signupRequest.getEmail());
        newUser.setPassword(passwordEncode.encode(signupRequest.getPassword()));

        List<Role> roles = new ArrayList<>();
        Role userRole = roleRepo.getByName("CLIENT");
        roles.add(userRole);

        newUser.setRoles(roles);

        User savedUser = userRepo.save(newUser);

        return savedUser;
    }
}
