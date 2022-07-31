package edu.miu.lab6springsecurity.service;

import edu.miu.lab6springsecurity.dto.UserDto;

import java.util.List;

public interface UserService {
    public List<UserDto> findAll();
}
