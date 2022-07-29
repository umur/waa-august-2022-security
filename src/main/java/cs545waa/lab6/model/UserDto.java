package cs545waa.lab6.model;

import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int roleId;
}
