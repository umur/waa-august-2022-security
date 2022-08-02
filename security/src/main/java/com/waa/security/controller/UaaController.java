package com.waa.security.controller;

import com.waa.security.dto.LoginRequest;
import com.waa.security.dto.LoginResponse;
import com.waa.security.dto.RegisterRequest;
import com.waa.security.entity.User;
import com.waa.security.service.implementation.AuthenticationServiceImplementation;
import com.waa.security.service.implementation.UserServiceImplementation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class UaaController {
    private AuthenticationServiceImplementation authenticationServiceImplementation;
    private UserServiceImplementation userServiceImplementation;
    @PostMapping("/signin")
    public LoginResponse signin(@RequestBody LoginRequest loginRequest) {
        return new LoginResponse(authenticationServiceImplementation.signin(loginRequest));
    }

    @PostMapping("/signup")
    public User signup(@RequestBody RegisterRequest registerRequest) throws Exception {
        return userServiceImplementation.signup(registerRequest);
    }
}
