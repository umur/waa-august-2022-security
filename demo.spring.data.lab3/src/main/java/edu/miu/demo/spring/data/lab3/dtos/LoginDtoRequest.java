package edu.miu.demo.spring.data.lab3.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDtoRequest {
    private String userName;
    private String password;
}