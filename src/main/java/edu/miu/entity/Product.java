package edu.miu.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;

    @JsonManagedReference
    @ManyToOne
    private User user;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}