package com.waa.security.service.implementation;

import com.waa.security.dto.LoginRequest;
import com.waa.security.repository.UserRepository;
import com.waa.security.security.JwtHelper;
import com.waa.security.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImplementation implements AuthenticationService {
    private JwtHelper jwtHelper;
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;


    @Override
    public String signin(LoginRequest loginRequest) {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("This user could not be found!");
        }
        String token = jwtHelper.generateToken(loginRequest.getUsername());
        return token;
    }
}
