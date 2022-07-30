package edu.miu.springsecurity1.service.impl;

import edu.miu.springsecurity1.entity.User;
import edu.miu.springsecurity1.model.*;
import edu.miu.springsecurity1.repository.UserRepo;
import edu.miu.springsecurity1.security.JwtHelper;
import edu.miu.springsecurity1.service.UaaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class UaaServiceImpl implements UaaService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    private final UserRepo userRepo;
    private final JwtHelper jwtHelper;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
        }

        var userDetails =  userRepo.findByEmail(loginRequest.getEmail());
        Map<String, Object> claimMap = new HashMap<>();
        claimMap.put("user_id", Integer.toString(userDetails.getId()));
        final String accessToken = jwtHelper.generateToken(loginRequest.getEmail(), claimMap);
        final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new LoginResponse(accessToken, refreshToken);
        return loginResponse;
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtHelper.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {
            var userName = jwtHelper.getUsernameFromToken(refreshTokenRequest.getRefreshToken());
            var userDetails =  userRepo.findByEmail(userName);
            Map<String, Object> claimMap = new HashMap<>();
            claimMap.put("user_id", Integer.toString(userDetails.getId()));
            final String accessToken = jwtHelper.generateToken(jwtHelper.getSubject(refreshTokenRequest.getRefreshToken()), claimMap);
            var loginResponse = new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());

            return loginResponse;
        }
        return new LoginResponse();
    }

    @Override
    public SignUpResponse signUp(SignUpRequest signUpRequest) {
        ModelMapper modelMapper = new ModelMapper();
        signUpRequest.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        var newUser = modelMapper.map(signUpRequest, User.class);
        newUser = userRepo.save(newUser);
        return modelMapper.map(newUser, SignUpResponse.class);
    }
}
