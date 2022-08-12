package edu.miu.spring_data.dto;

import edu.miu.spring_data.entity.Address;
import edu.miu.spring_data.entity.Product;
import edu.miu.spring_data.entity.Review;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private int id;
    private String email;
    private String password;
    private String firstname;
    private String lastname ;
    private int addressId ;
//    private List<Product> products ;
//    private List<Review> reviews;
//    private Address address ;
}
