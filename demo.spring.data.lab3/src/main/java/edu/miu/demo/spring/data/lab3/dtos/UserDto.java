package edu.miu.demo.spring.data.lab3.dtos;

import edu.miu.demo.spring.data.lab3.models.Address;
import edu.miu.demo.spring.data.lab3.models.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Address address;
    private List<Review> reviews;
}
