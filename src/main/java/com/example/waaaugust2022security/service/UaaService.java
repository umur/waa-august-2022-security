package com.example.waaaugust2022security.service;


import com.example.waaaugust2022security.model.LoginRequest;
import com.example.waaaugust2022security.model.LoginResponse;
import com.example.waaaugust2022security.model.RefreshTokenRequest;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
