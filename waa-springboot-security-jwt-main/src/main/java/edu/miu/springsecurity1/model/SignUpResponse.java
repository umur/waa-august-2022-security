package edu.miu.springsecurity1.model;

import lombok.Data;

@Data
public class SignUpResponse {
    private String email;
    private String firstName;
    private String lastName;
}
