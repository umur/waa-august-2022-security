package edu.miu.lab6.service;

import edu.miu.lab6.entity.User;
import edu.miu.lab6.model.LoginRequest;
import edu.miu.lab6.model.LoginResponse;
import edu.miu.lab6.model.SignupRequest;

public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);
    User signup(SignupRequest signupRequest);
}
