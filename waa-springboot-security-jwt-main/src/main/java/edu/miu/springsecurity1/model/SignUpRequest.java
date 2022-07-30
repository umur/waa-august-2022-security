package edu.miu.springsecurity1.model;

import lombok.Data;

@Data
public class SignUpRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastname;
}
