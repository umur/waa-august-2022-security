package edu.miu.lab6.controller;

import edu.miu.lab6.model.LoginRequest;
import edu.miu.lab6.model.LoginResponse;
import edu.miu.lab6.model.SignupRequest;
import edu.miu.lab6.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("signup")
    ResponseEntity<?> login(@RequestBody SignupRequest signupRequest) {
        var loginResponse = authService.signup(signupRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("login")
    ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = authService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

}
