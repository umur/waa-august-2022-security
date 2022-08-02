package com.waa.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private int id;
    private String name;
    private float rating;
    private double price;
    private CategoryDto category;
}
