package com.webshop.mapping.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String role;

    private String email;

    private String password;

    private List<ReviewDto> reviews;

    private AddressDto address;

}
