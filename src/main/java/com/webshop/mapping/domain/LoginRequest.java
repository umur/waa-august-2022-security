package com.webshop.mapping.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {

    private String email;

    private String password;

}
