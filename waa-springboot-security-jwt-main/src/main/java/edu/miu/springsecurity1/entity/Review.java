package edu.miu.springsecurity1.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comment;
    private int numberOfStars;

    @JsonBackReference(value = "product-review")
    @ManyToOne
    private Product product;

}
