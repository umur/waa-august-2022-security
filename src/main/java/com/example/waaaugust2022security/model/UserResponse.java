package com.example.waaaugust2022security.model;

import com.example.waaaugust2022security.entity.Review;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
@Data
@RequiredArgsConstructor
public class UserResponse {

        private Long id;

        private String firstName;

        private String lastName;

        private String role;

        private String email;

        private List<Review> reviews;

}
