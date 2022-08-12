package edu.miu.spring_data.dto;


import edu.miu.spring_data.entity.User;
import lombok.Data;


@Data
public class AddressDto {
    private int id;
    private String street;
    private int zip;
    private String city;


    private User user ;
}
