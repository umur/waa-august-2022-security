package edu.miu.demo.spring.data.lab3.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenDtoRequest {
    private String refreshToken;
}
