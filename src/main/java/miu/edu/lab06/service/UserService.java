package miu.edu.lab06.service;

import miu.edu.lab06.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> getAll();
    Optional<UserDTO> getById(Long id);
    UserDTO save(UserDTO user);
    void delete(Long id);
}
