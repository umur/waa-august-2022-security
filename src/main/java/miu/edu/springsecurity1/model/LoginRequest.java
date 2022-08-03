package miu.edu.springsecurity1.model;

import lombok.Builder;
import lombok.Data;
import miu.edu.springsecurity1.entity.Role;

import java.util.List;

@Data
@Builder
public class LoginRequest {
    private String username;
    private String password;
}