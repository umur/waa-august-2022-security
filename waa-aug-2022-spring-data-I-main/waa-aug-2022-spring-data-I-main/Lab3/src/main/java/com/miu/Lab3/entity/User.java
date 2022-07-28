package com.miu.Lab3.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "productUser")
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastname;

    @OneToOne
    @JsonManagedReference
    private Address address;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<Review> reviews;
}
