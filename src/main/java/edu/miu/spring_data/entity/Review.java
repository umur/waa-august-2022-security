package edu.miu.spring_data.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comment ;

    @ManyToOne
    @JoinColumn(name="User_ID")
    @JsonManagedReference
    private User user ;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Product_ID")
    @JsonManagedReference
    private Product product;

    public Review(String comment) {
        this.comment = comment;
    }
}
