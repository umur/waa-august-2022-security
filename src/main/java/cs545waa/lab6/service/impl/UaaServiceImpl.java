package cs545waa.lab6.service.impl;

import cs545waa.lab6.entity.Role;
import cs545waa.lab6.entity.User;
import cs545waa.lab6.model.SigninRequest;
import cs545waa.lab6.model.SigninResponse;
import cs545waa.lab6.model.UserDto;
import cs545waa.lab6.repo.RoleRepo;
import cs545waa.lab6.repo.UserRepo;
import cs545waa.lab6.security.JwtHelper;
import cs545waa.lab6.service.UaaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UaaServiceImpl implements UaaService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtHelper jwtHelper;

    public User signup(UserDto userDto) {
        User user = new User(
                0,
                userDto.getUsername(),
                passwordEncoder.encode(userDto.getPassword()),
                userDto.getFirstName(),
                userDto.getLastName(),
                roleRepo.findById(userDto.getRoleId()).get());
        return userRepo.save(user);
    }

    public ResponseEntity<SigninResponse> signin(SigninRequest signinRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(signinRequest.getUsername(),
                            signinRequest.getPassword()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        return ResponseEntity.ok().body(new SigninResponse(jwtHelper.generateToken(signinRequest.getUsername())));
    }
}
