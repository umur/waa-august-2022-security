package com.waa.lab.entity;

import lombok.Data;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private int price;
    private int rating;

    @ManyToOne()
    private Category category;

    @BatchSize(size = 2)
    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User creator;
}
