package edu.miu.controller;

import edu.miu.model.LoginRequest;
import edu.miu.model.UserDto;
import edu.miu.service.UaaService;
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

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = uaaService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<?> signUpUser(@RequestBody UserDto user) {
        return uaaService.signUp(user);
    }

}
