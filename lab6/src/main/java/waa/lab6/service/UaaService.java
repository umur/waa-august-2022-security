package waa.lab6.service;

import waa.lab6.entity.User;
import waa.lab6.model.LoginRequest;
import waa.lab6.model.LoginResponse;

public interface UaaService {

    LoginResponse login(LoginRequest loginRequest);

    void signUp(User user);
}
