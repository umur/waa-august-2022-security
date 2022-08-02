package com.waa.security.dto;

import com.waa.security.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int id;
    private String firstName;
    private String lastName;
    private List<Role> roles;
    private String email;
}
