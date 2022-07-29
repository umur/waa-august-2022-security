package edu.miu.demo.spring.data.lab3.services.impl;

import edu.miu.demo.spring.data.lab3.dtos.*;
import edu.miu.demo.spring.data.lab3.repos.RoleRepo;
import edu.miu.demo.spring.data.lab3.repos.UserRepo;
import edu.miu.demo.spring.data.lab3.security.helper.JwtHelper;
import edu.miu.demo.spring.data.lab3.services.UaaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import edu.miu.demo.spring.data.lab3.models.User;
import edu.miu.demo.spring.data.lab3.models.Role;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@Slf4j
public class UaaServiceImpl implements UaaService {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    private final JwtHelper jwtHelper;

    @Override
    public LoginDtoResponse login(LoginDtoRequest loginRequest) {
        try {
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),
                            loginRequest.getPassword())
            );

        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
            throw e;
        }

        final String accessToken = jwtHelper.generateToken(loginRequest.getUserName());
        final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getUserName());
        var loginResponse = new LoginDtoResponse(accessToken, refreshToken);
        return loginResponse;
    }

    @Override
    public LoginDtoResponse refreshToken(RefreshTokenDtoRequest refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtHelper.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {
            final String accessToken = jwtHelper.generateToken(jwtHelper.getSubject(refreshTokenRequest.getRefreshToken()));
            var loginResponse = new LoginDtoResponse(accessToken, refreshTokenRequest.getRefreshToken());
            return loginResponse;
        }
        return new LoginDtoResponse();
    }

    @Override
    public SignUpDtoResponse signup(SignUpDtoRequest signUpRequest) {
        User user = new User();
        user.setUserName(signUpRequest.getUserName());
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        var encodedPwd = passwordEncoder.encode(signUpRequest.getPassword());
        user.setPassword(encodedPwd);

        var userRole = roleRepo.findById(signUpRequest.getRoleId()).orElse(null);
        var roles = new ArrayList<Role>();
        roles.add(userRole);
        user.setRole(roles);

        userRepo.save(user);
        return new SignUpDtoResponse(user);
    }
}

