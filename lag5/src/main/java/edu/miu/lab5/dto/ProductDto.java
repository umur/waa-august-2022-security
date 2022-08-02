package edu.miu.lab5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private int id;

    private String name;
    private float price;

    private UserDto user;
}
