package miu.edu.springsecurity1.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import miu.edu.springsecurity1.entity.Role;
import miu.edu.springsecurity1.model.LoginRequest;
import miu.edu.springsecurity1.model.LoginResponse;
import miu.edu.springsecurity1.model.RefreshTokenRequest;
import miu.edu.springsecurity1.security.JwtHelper;
import miu.edu.springsecurity1.service.UaaService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UaaServiceImpl implements UaaService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtHelper jwtHelper;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            System.out.println("PASSWORD: "+loginRequest.getPassword());
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                            loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        final String accessToken = jwtHelper.createToken(loginRequest.getUsername(), new ArrayList<>(userDetails.getAuthorities()));
        final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getUsername());
        var loginResponse = new LoginResponse(accessToken, refreshToken);
        return loginResponse;
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtHelper.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {
            final String accessToken = jwtHelper.createToken(
                    jwtHelper.getSubject(refreshTokenRequest.getRefreshToken()),
                    jwtHelper.getRoles(refreshTokenRequest.getRefreshToken())
            );
            var loginResponse = new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());
            return loginResponse;
        }
        return new LoginResponse();
    }
}
