package com.webshop.mapping.dto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private Long id;

    private String street;

    private String zip;

    private String city;
}
