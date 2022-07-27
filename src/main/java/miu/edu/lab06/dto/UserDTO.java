package miu.edu.lab06.dto;

import lombok.Data;
import miu.edu.lab06.aspect.WaaWord;

import java.util.List;

@Data
public class UserDTO {
    private Long id;
    @WaaWord
    private String firstname;
    @WaaWord
    private String lastname;
    @WaaWord
    private String username;
    @WaaWord
    private String password;
    @WaaWord
    private String email;
    private List<RoleDTO> roles;
}
