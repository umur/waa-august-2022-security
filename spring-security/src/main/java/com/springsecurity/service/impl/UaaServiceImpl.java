package com.springsecurity.service.impl;

import com.springsecurity.model.LoginRequest;
import com.springsecurity.model.LoginResponse;
import com.springsecurity.model.RefreshTokenRequest;
import com.springsecurity.security.filter.Helper;
import com.springsecurity.service.UaaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UaaServiceImpl implements UaaService {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final Helper helper;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                            loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            log.info(e.getMessage());
        }

        final String access_token = helper.getAccessToken(loginRequest.getUsername());
        final String refresh_token = helper.getRefreshToken(loginRequest.getUsername());
        return new LoginResponse(access_token, refresh_token);
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        boolean isRefreshTokenValid = helper.validateToken(refreshTokenRequest.getRefresh_token());
        if (isRefreshTokenValid) {
            final String access_token = helper.getAccessToken(helper.getUsernameFromToken(refreshTokenRequest.getRefresh_token()));
            return new LoginResponse(access_token, refreshTokenRequest.getRefresh_token());
        }
        return new LoginResponse();
    }
}
