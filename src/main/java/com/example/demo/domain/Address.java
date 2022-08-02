package com.example.demo.domain;

import lombok.Data;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private String zip;

    private String city;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
