package miu.edu.waaaugust2022security.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import miu.edu.waaaugust2022security.entity.Review;

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
