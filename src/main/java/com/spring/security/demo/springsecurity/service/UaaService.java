package com.spring.security.demo.springsecurity.service;

import com.spring.security.demo.springsecurity.model.LoginRequest;
import com.spring.security.demo.springsecurity.model.LoginResponse;
import com.spring.security.demo.springsecurity.model.RefreshTokenRequest;
import org.springframework.stereotype.Service;

@Service
public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
