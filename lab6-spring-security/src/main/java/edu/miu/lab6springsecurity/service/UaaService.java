package edu.miu.lab6springsecurity.service;

import edu.miu.lab6springsecurity.dto.UserDto;
import edu.miu.lab6springsecurity.entity.User;
import edu.miu.lab6springsecurity.model.LoginRequest;
import edu.miu.lab6springsecurity.model.LoginResponse;

public interface UaaService {
    public LoginResponse login(LoginRequest loginRequest);
    public UserDto signup(User user);
}
