package com.waa.lab.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

@Data
public class ReviewDTO {
    private int id;
    private String comment;

    @JsonBackReference
//    @JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="id")
    private ProductDTO product;
}
