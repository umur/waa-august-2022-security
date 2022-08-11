package com.example.waaaugust2022security.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String comment;
    private int numberOfStars;

    @ManyToOne
    private Product product;
}
