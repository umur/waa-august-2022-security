package com.example.waaaugust2022security.service;

import com.example.waaaugust2022security.entity.User;
import com.example.waaaugust2022security.model.LoginRequest;
import com.example.waaaugust2022security.model.LoginResponse;
import com.example.waaaugust2022security.model.RefreshTokenRequest;
import com.example.waaaugust2022security.model.UserResponse;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

    UserResponse save(User user);
}
