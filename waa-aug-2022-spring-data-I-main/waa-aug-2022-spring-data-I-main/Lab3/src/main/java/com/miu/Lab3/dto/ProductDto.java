package com.miu.Lab3.dto;

import com.miu.Lab3.entity.Category;
import com.miu.Lab3.entity.Review;
import lombok.Data;

import java.util.List;

@Data
public class ProductDto {
    private int id;
    private String name;
    private double price;
    private  int rating;
    private CategoryDto category;

    private List<ReviewDto> reviews;
}
