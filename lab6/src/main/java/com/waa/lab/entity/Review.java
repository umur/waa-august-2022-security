package com.waa.lab.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String comment;

    @ManyToOne()
    private Product product;
}
