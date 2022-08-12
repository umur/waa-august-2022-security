package com.webshop.mapping.dto;

import com.webshop.mapping.domain.Category;
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
