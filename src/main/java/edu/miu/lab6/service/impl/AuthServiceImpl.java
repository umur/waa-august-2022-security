package edu.miu.lab6.service.impl;

import edu.miu.lab6.entity.Role;
import edu.miu.lab6.entity.User;
import edu.miu.lab6.model.LoginRequest;
import edu.miu.lab6.model.LoginResponse;
import edu.miu.lab6.model.SignupRequest;
import edu.miu.lab6.repo.RoleRepo;
import edu.miu.lab6.repo.UserRepo;
import edu.miu.lab6.security.JwtHelper;
import edu.miu.lab6.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private  AuthenticationManager authenticationManager;
    private JwtHelper jwtHelper;
    private RoleRepo roleRepo;
    private UserRepo userRepo;

    private BCryptPasswordEncoder passwordEncode;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        log.info("coming");
        try {
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword() )
            );
            log.info("==> "+result);
        }
        catch (BadCredentialsException e) {
            log.info("Bad Credentials");
        }
        final String accessToken = jwtHelper.generateToken(loginRequest.getEmail());
        //final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getEmail());
        return new LoginResponse(accessToken);
    }


    public User signup(SignupRequest signupRequest){

        User newUser = new User();
        newUser.setName(signupRequest.getName());
        newUser.setEmail(signupRequest.getEmail());
        newUser.setPassword(passwordEncode.encode(signupRequest.getPassword()));

        List<Role> roles = new ArrayList<>();
        Role userRole = roleRepo.getByName("CLIENT");
        roles.add(userRole);

        newUser.setRoles(roles);

        User savedUser = userRepo.save(newUser);

        return savedUser;
    }
}
