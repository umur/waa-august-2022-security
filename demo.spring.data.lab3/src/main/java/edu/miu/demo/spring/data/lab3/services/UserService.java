package edu.miu.demo.spring.data.lab3.services;

import edu.miu.demo.spring.data.lab3.dtos.UserDto;

import java.util.List;

public interface UserService {
    public List<UserDto> getAll();
    public void save(UserDto userDto);
    public void delete(int id);
}
