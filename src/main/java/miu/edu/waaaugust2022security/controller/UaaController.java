package miu.edu.waaaugust2022security.controller;

import miu.edu.waaaugust2022security.entity.User;
import miu.edu.waaaugust2022security.model.LoginRequest;
import miu.edu.waaaugust2022security.model.LoginResponse;
import miu.edu.waaaugust2022security.model.RefreshTokenRequest;
import miu.edu.waaaugust2022security.model.UserResponse;
import miu.edu.waaaugust2022security.service.UaaService;
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

    @PostMapping("/signup")
    public ResponseEntity<UserResponse> signup(@RequestBody User user){
        UserResponse userResponse = uaaService.save(user);
        return ResponseEntity.ok(userResponse);
    }

}
