package com.example.demo.domain;

import lombok.Data;

import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    private Double rating;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "created_by")
    private User user;
}
