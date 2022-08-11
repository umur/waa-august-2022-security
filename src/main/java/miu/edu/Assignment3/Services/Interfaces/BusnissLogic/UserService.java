package miu.edu.Assignment3.Services.Interfaces.BusnissLogic;

import miu.edu.Assignment3.DTOs.BuisnessLogicDTO.UserDTO;


import java.util.List;

public interface UserService {
    void save(UserDTO userDTO);
    void delete(Long id);
    UserDTO getById(Long id);
    List<UserDTO> getAll();
    void update(UserDTO userDTO, long id);
}
