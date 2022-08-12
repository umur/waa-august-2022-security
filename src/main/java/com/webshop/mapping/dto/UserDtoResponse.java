package com.webshop.mapping.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String role;

    private String email;

    private List<ReviewDto> reviews;

    private AddressDto address;
}
