package com.springsecurity.api;

import com.springsecurity.domain.AppUser;
import com.springsecurity.model.LoginRequest;
import com.springsecurity.model.LoginResponse;
import com.springsecurity.model.RefreshTokenRequest;
import com.springsecurity.service.AppUserService;
import com.springsecurity.service.RoleService;
import com.springsecurity.service.UaaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@RestController
@RequestMapping("/api")
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
public class UaaController {
    private final UaaService uaaService;
    private final AppUserService appUserService;
    private final RoleService roleService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = uaaService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody AppUser appUser){
        appUser.setRoles(new ArrayList<>(Collections.singletonList(roleService.getRoleByName("USER"))));
        log.info(appUser.toString());
        return ResponseEntity.ok().body(appUserService.save(appUser));
    }

    @PostMapping("/refresh-token")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        log.info(refreshTokenRequest.getRefresh_token());
        return uaaService.refreshToken(refreshTokenRequest);
    }

}
