package edu.miu.demo.spring.data.lab3.dtos;


import edu.miu.demo.spring.data.lab3.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDtoResponse {
    private User user;
}
