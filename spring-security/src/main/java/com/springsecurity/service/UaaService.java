package com.springsecurity.service;

import com.springsecurity.model.LoginRequest;
import com.springsecurity.model.LoginResponse;
import com.springsecurity.model.RefreshTokenRequest;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
