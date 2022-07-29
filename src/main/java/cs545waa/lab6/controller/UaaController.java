package cs545waa.lab6.controller;

import cs545waa.lab6.entity.User;
import cs545waa.lab6.model.SigninRequest;
import cs545waa.lab6.model.SigninResponse;
import cs545waa.lab6.model.UserDto;
import cs545waa.lab6.service.UaaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UaaController {
    private final UaaService uaaService;

    @PostMapping
    @RequestMapping("/signup")
    public User signup(@RequestBody UserDto userDto) {
        return uaaService.signup(userDto);
    }

    @PostMapping
    @RequestMapping("/signin")
    public ResponseEntity<SigninResponse> signin(@RequestBody SigninRequest signinRequest) {
        return uaaService.signin(signinRequest);
    }

    @GetMapping
    @RequestMapping("/users")
    public String getUsers() {
        return "all users";
    }
}
