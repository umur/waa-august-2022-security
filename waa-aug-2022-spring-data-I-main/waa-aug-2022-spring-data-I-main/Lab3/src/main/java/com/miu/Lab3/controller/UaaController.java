package com.miu.Lab3.controller;

import com.miu.Lab3.model.LoginRequest;
import com.miu.Lab3.model.LoginResponse;
import com.miu.Lab3.model.RefreshTokenRequest;
import com.miu.Lab3.service.UaaService;
import com.miu.Lab3.model.LoginResponse;
import com.miu.Lab3.model.RefreshTokenRequest;
import com.miu.Lab3.service.UaaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/uaa")
@CrossOrigin
public class UaaController {

    private final UaaService uaaService;

    public UaaController(UaaService uaaService) {
        this.uaaService = uaaService;
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
