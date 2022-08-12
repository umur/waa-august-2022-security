package edu.miu.spring_data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double price;
    private double rating;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private User user ;

    @ManyToOne
    @JsonManagedReference
    private Category category;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.PERSIST , mappedBy ="product")
    private List<Review> reviews= new ArrayList<>();

    public Product(String name, double price, double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }
}
