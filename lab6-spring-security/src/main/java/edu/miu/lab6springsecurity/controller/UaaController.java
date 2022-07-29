package edu.miu.lab6springsecurity.controller;

import edu.miu.lab6springsecurity.dto.UserDto;
import edu.miu.lab6springsecurity.entity.User;
import edu.miu.lab6springsecurity.model.LoginRequest;
import edu.miu.lab6springsecurity.service.UaaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/uaa")
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

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        return ResponseEntity.ok().body(uaaService.signup(user));
    }
}
