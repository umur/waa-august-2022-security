package com.webshop.mapping.service;

import com.webshop.mapping.domain.LoginRequest;
import com.webshop.mapping.domain.LoginResponse;
import com.webshop.mapping.dto.UserDto;
import com.webshop.mapping.dto.UserDtoResponse;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto findById(Long id);

    UserDtoResponse save(UserDto user);

    void remove(Long id);

    LoginResponse login(LoginRequest loginRequest);

}
