package edu.miu.lab6springsecurity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class UserDto {
    private int id;
    private String email;
    @JsonIgnore
    private String password;
    private String firstname;
    private String lastname;
}
