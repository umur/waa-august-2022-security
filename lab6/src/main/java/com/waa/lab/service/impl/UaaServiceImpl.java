package com.waa.lab.service.impl;

import com.waa.lab.entity.Role;
import com.waa.lab.entity.User;
import com.waa.lab.model.SigninRequest;
import com.waa.lab.model.SigninResponse;
import com.waa.lab.repository.RoleRepository;
import com.waa.lab.repository.UserRepository;
import com.waa.lab.security.JwtHelper;
import com.waa.lab.service.UaaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
@Slf4j
public class UaaServiceImpl implements UaaService {

    private final AuthenticationManager authenticationManager;
    private final JwtHelper jwtHelper;

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final static String USER_ROLE = "USER";

    @Override
    public SigninResponse signin(SigninRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword())
            );
        } catch (Exception e) {
            log.warn("Authenticate fail", e);
            return null;
        }

        final String accessToken = jwtHelper.generateToken(loginRequest.getEmail());
        final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getEmail());
        return new SigninResponse(accessToken, refreshToken);
    }

    @Override
    public void signup(User user) {
        Role userRole = roleRepository.findByRole(USER_ROLE);
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);
    }
}
