package edu.miu.service;

import edu.miu.model.LoginRequest;
import edu.miu.model.LoginResponse;
import edu.miu.model.UserDto;
import org.springframework.http.ResponseEntity;

public interface UaaService {
    ResponseEntity<LoginResponse> login(LoginRequest loginRequest);

    ResponseEntity<?> signUp(UserDto userDto);
}