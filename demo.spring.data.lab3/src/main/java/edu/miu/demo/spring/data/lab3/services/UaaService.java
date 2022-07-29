package edu.miu.demo.spring.data.lab3.services;

import edu.miu.demo.spring.data.lab3.dtos.*;

public interface UaaService {
    LoginDtoResponse login(LoginDtoRequest loginRequest);

    LoginDtoResponse refreshToken(RefreshTokenDtoRequest refreshTokenRequest);

    SignUpDtoResponse signup(SignUpDtoRequest signUpRequest);

}
