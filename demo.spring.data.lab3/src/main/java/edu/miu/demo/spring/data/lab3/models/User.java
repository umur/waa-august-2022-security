package edu.miu.demo.spring.data.lab3.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "username")
    private String userName;

    @JsonIgnore
    private String password;

    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//  @JsonManagedReference
    private List<Product> products;
}
