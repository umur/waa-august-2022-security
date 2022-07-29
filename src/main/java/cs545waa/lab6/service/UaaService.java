package cs545waa.lab6.service;

import cs545waa.lab6.entity.User;
import cs545waa.lab6.model.SigninRequest;
import cs545waa.lab6.model.SigninResponse;
import cs545waa.lab6.model.UserDto;
import org.springframework.http.ResponseEntity;

public interface UaaService {
    User signup(UserDto userDto);
    ResponseEntity<SigninResponse> signin(SigninRequest signinRequest);
}
