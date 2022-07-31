package com.example.lab5sec.service;

import com.example.lab5sec.entity.User;
import com.example.lab5sec.model.LoginRequest;
import com.example.lab5sec.model.LoginResponse;
import com.example.lab5sec.model.SignupRequest;
import com.example.lab5sec.model.SignupResponse;

public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);
    User signup(SignupRequest signupRequest);
}
