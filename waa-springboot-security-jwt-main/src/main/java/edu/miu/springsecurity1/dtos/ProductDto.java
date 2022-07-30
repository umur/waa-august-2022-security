package edu.miu.springsecurity1.dtos;

import lombok.Data;

@Data
public class ProductDto {
    private int id;
    private String name;
    private float price;
    private UserDto user;
}
