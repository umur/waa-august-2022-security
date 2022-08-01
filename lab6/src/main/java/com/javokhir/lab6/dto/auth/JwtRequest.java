package com.javokhir.lab6.dto.auth;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "password")
public class JwtRequest {

    private String username;
    private String password;
}
