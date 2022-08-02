package edu.miu.lab5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Register {
    private String email;
    private String password;
    private String firstname;
    private String lastname;
}
