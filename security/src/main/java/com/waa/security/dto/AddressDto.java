package com.waa.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private int id;
    private String street;
    private int zip;
    private String city;
    private int userId;
}
