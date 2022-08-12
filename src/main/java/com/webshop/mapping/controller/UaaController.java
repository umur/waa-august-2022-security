package com.webshop.mapping.controller;

import com.webshop.mapping.domain.LoginRequest;
import com.webshop.mapping.dto.UserDto;
import com.webshop.mapping.dto.UserDtoResponse;
import com.webshop.mapping.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class UaaController {

    private UserService userService;

    public UaaController(UserService uaaService) {
        this.userService = uaaService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = userService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDtoResponse> signup(@RequestBody UserDto userDto){
        UserDtoResponse userDtoResponse = userService.save(userDto);
        return ResponseEntity.ok(userDtoResponse);
    }

}
