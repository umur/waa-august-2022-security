package edu.miu.spring_data.service;

import edu.miu.spring_data.model.LoginRequest;
import edu.miu.spring_data.model.LoginResponse;
import edu.miu.spring_data.model.RefreshTokenRequest;


public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
