package com.miu.Lab3.service;

import com.miu.Lab3.model.LoginRequest;
import com.miu.Lab3.model.LoginResponse;
import com.miu.Lab3.model.RefreshTokenRequest;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
