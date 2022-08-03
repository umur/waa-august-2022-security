package miu.edu.springsecurity1.service;

import miu.edu.springsecurity1.model.LoginRequest;
import miu.edu.springsecurity1.model.LoginResponse;
import miu.edu.springsecurity1.model.RefreshTokenRequest;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}