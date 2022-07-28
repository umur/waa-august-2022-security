package com.miu.Lab3.dto;

import com.miu.Lab3.entity.Address;
import com.miu.Lab3.entity.Review;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastname;
    private Address address;
    private List<Review> reviews;
}
