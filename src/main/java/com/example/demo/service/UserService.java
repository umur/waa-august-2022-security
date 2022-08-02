package com.example.demo.service;

import com.example.demo.domain.LoginRequest;
import com.example.demo.domain.LoginResponse;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserDtoResponse;


import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto findById(Long id);

    UserDtoResponse save(UserDto user);

    void remove(Long id);

    LoginResponse login(LoginRequest loginRequest);

}
