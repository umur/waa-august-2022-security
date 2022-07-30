package edu.miu.springsecurity1.controller;

import edu.miu.springsecurity1.model.LoginRequest;
import edu.miu.springsecurity1.model.LoginResponse;
import edu.miu.springsecurity1.model.RefreshTokenRequest;
import edu.miu.springsecurity1.model.SignUpRequest;
import edu.miu.springsecurity1.service.UaaService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/uaa")
@CrossOrigin
@RequiredArgsConstructor
public class UaaController {

    private final UaaService uaaService;

    @PostMapping("/signUp")
    public ResponseEntity<?> SignUp(@RequestBody SignUpRequest signUpRequest) {
        var signUpResponse = uaaService.signUp(signUpRequest);
        return ResponseEntity.ok().body(signUpResponse);
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = uaaService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return uaaService.refreshToken(refreshTokenRequest);
    }

}
