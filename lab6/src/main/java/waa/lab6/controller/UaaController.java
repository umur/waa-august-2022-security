package waa.lab6.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import waa.lab6.entity.User;
import waa.lab6.model.LoginRequest;
import waa.lab6.model.LoginResponse;
import waa.lab6.service.UaaService;

@RestController
@RequestMapping("/uaa")
@RequiredArgsConstructor
public class UaaController {
    private final UaaService uaaService;

    @PostMapping
    public LoginResponse signIn(@RequestBody LoginRequest loginRequest) {
        return uaaService.login(loginRequest);
    }

    @PostMapping("/signUp")
    public void signUp(@RequestBody User user) {
        uaaService.signUp(user);
    }
}
