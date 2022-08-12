package edu.miu.spring_data.controller;


import edu.miu.spring_data.model.SignUpDto;
import edu.miu.spring_data.model.LoginRequest;
import edu.miu.spring_data.model.LoginResponse;
import edu.miu.spring_data.model.RefreshTokenRequest;
import edu.miu.spring_data.service.UaaService;
import edu.miu.spring_data.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/uaa")
@CrossOrigin
public class UaaController {

    private final UaaService uaaService;
    private final UserService userService;


    public UaaController(UaaService uaaService , UserService userService ) {
        this.uaaService = uaaService;
        this.userService = userService ;

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = uaaService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return uaaService.refreshToken(refreshTokenRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser (@RequestBody SignUpDto signUpDto)
    {
        // add check for user exists in DB
        if(userService.findByEmail(signUpDto.getEmail()) != null){
            return new ResponseEntity<>("User email is already taken!", HttpStatus.BAD_REQUEST);
        }
        userService.addSignUpUser(signUpDto);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }


}
