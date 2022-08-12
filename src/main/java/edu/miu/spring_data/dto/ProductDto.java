package edu.miu.spring_data.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.miu.spring_data.entity.User;
import lombok.Data;

@Data
public class ProductDto {

    private int id;
    private String name;
    private double price;
    private double rating;
    //private User user ;


}
