package security.lab6.service;


import security.lab6.model.LoginRequest;
import security.lab6.model.LoginResponse;
import security.lab6.model.RefreshTokenRequest;
import security.lab6.model.SignupRequest;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse signup(SignupRequest req);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
