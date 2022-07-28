package edu.miu.service.impl;

import edu.miu.entity.Role;
import edu.miu.entity.User;
import edu.miu.jwt.RoleName;
import edu.miu.jwt.TokenProvider;
import edu.miu.model.LoginRequest;
import edu.miu.model.LoginResponse;
import edu.miu.model.UserDto;
import edu.miu.repository.RoleRepository;
import edu.miu.repository.UserRepository;
import edu.miu.service.UaaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
@Slf4j
public class UaaServiceImpl implements UaaService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final RoleRepository roleRepository;

    @Override
    public ResponseEntity<LoginResponse> login(LoginRequest loginRequest) {
        try {
            Authentication result = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
            final String accessToken = tokenProvider.generateToken(result);
            return ResponseEntity.ok(new LoginResponse(accessToken));
        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<?> signUp(UserDto userDto) {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            return new ResponseEntity<String>("Fail -> Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }
        User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()), userDto.getFirstname(), userDto.getLastname());

        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("User Role not set."));
        user.setRoles(Collections.singletonList(userRole));


        userRepository.save(user);
        return ResponseEntity.ok().body("User signed up successfully");
    }
}
