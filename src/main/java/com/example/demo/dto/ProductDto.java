package com.example.demo.dto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDto {

    private Long id;

    private String name;

    private double price;

    private Double rating;

    private CategoryDto category;

}
