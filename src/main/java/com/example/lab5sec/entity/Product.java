package com.example.lab5sec.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    double price;

    double rating;

    @ManyToOne
//    @JoinColumn(name = "owner_id")
    User owner; //
}
