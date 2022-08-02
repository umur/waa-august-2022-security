package security.lab6.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import security.lab6.model.LoginRequest;
import security.lab6.model.LoginResponse;
import security.lab6.model.RefreshTokenRequest;
import security.lab6.model.SignupRequest;
import security.lab6.service.UaaService;

@RestController
@RequestMapping("/api/v1/uaa")
@CrossOrigin
public class UaaController {

    private final UaaService uaaService;

    public UaaController(UaaService uaaService) {
        this.uaaService = uaaService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = uaaService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest req) {
        var response = uaaService.signup(req);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return uaaService.refreshToken(refreshTokenRequest);
    }

}
