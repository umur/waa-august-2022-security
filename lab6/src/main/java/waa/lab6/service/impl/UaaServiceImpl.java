package waa.lab6.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import waa.lab6.entity.User;
import waa.lab6.model.LoginRequest;
import waa.lab6.model.LoginResponse;
import waa.lab6.repository.UserRepo;
import waa.lab6.security.JwtHelper;
import waa.lab6.service.UaaService;

@Service
@RequiredArgsConstructor
@Slf4j
public class UaaServiceImpl implements UaaService {

    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
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
        LoginResponse loginResponse = new LoginResponse(jwtHelper.generateToken(loginRequest.getEmail()),
                jwtHelper.generateRefreshToken(loginRequest.getEmail()));
        return loginResponse;
    }

    @Override
    public void signUp(User userIn) {
        User user = userRepo.findByEmail(userIn.getEmail());
        if (user == null) {
            userIn.setPassword(passwordEncoder.encode(userIn.getPassword()));
            userRepo.save(userIn);
        }
    }
}
