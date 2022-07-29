package com.waa.lab.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class UserDTO {
    private int id;
    private String email;
    @JsonIgnore
    private String password;
    private String firstName;
    private String lastName;
    private AddressDTO address;
}
