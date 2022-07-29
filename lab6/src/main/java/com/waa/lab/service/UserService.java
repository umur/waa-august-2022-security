package com.waa.lab.service;

import com.waa.lab.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> findAll();

    Optional<UserDTO> findById(Integer id);

    void save(UserDTO userDTO);

    void deleteById(Integer id);
}
