package com.javokhir.lab6.controller;

import com.javokhir.lab6.configuration.security.filter.JwtTokenUtil;
import com.javokhir.lab6.dto.auth.JwtRequest;
import com.javokhir.lab6.dto.auth.JwtResponse;
import com.javokhir.lab6.sevice.auth.Security;
import lombok.AllArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/api")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final Security security;

    @PostMapping("/auth")
    public JwtResponse createAuthenticationToken(@RequestBody JwtRequest request) {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (Exception e) {
            throw new AccessDeniedException("Can not authenticate", e);
        }

        UserDetails userDetails = security.loadUserByUsername(request.getUsername());

        var token = jwtTokenUtil.generateToken(userDetails);

        return new JwtResponse(token);
    }
}
