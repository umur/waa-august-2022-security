package edu.miu.springsecurity1.service;

import edu.miu.springsecurity1.model.*;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

    SignUpResponse signUp(SignUpRequest signUpRequest);
}
