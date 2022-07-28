package com.miu.Lab3.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue
    @Column(updatable = false)
    private int id;
    private String name;
    private double price;
    private  int rating;

    @ManyToOne
    @JsonManagedReference
    private Category category;

    @OneToMany
    @JoinColumn(name="product_id")
    @JsonManagedReference
    private List<Review> reviews;
}
