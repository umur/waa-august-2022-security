package com.waa.lab.dto;

import com.waa.lab.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {
    private int id;
    private String name;
    private int price;
    private int rating;
    private CategoryDTO category;
    private List<ReviewDTO> reviews;
    private UserDTO creator;

}
