package com.waa.lab.controller;

import com.waa.lab.entity.User;
import com.waa.lab.model.SigninRequest;
import com.waa.lab.model.SigninResponse;
import com.waa.lab.service.UaaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uaa")
public class UaaController {
    @Autowired
    private UaaService uaaService;

    @PostMapping("/signin")
    SigninResponse signin(@RequestBody SigninRequest signinRequest){
        return uaaService.signin(signinRequest);
    }

    @PostMapping("/signup")
    void signup(@RequestBody User user){
        uaaService.signup(user);
    }
}
