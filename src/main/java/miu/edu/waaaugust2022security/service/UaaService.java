package miu.edu.waaaugust2022security.service;

import miu.edu.waaaugust2022security.entity.User;
import miu.edu.waaaugust2022security.model.LoginRequest;
import miu.edu.waaaugust2022security.model.LoginResponse;
import miu.edu.waaaugust2022security.model.RefreshTokenRequest;
import miu.edu.waaaugust2022security.model.UserResponse;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

    UserResponse save(User user);
}
