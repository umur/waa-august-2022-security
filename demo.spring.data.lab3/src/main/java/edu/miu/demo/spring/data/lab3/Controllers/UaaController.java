package edu.miu.demo.spring.data.lab3.Controllers;

import edu.miu.demo.spring.data.lab3.dtos.*;
import edu.miu.demo.spring.data.lab3.services.UaaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/uaa")
@AllArgsConstructor
@CrossOrigin
public class UaaController {

    private final UaaService uaaService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDtoRequest loginRequest) {
        try {
            var loginResponse = uaaService.login(loginRequest);
            return ResponseEntity.ok().body(loginResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new LoginFailedDtoResponse("Login failed"));
        }
    }

    @PostMapping("/refreshToken")
    public LoginDtoResponse refreshToken(@RequestBody RefreshTokenDtoRequest refreshTokenRequest) {
        return uaaService.refreshToken(refreshTokenRequest);
    }

    @PostMapping("/signup")
    public SignUpDtoResponse signup(@RequestBody SignUpDtoRequest signUpRequest) {
        return uaaService.signup(signUpRequest);
    }
}
