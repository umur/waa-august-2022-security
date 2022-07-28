package edu.miu.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String password;
    private String firstname;
    private String lastname;
    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private List<Product> product;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Offense> offenses;

    public User(String email, String password, String firstname, String lastname) {
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}