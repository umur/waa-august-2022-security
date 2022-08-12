package com.webshop.mapping.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator",  sequenceName = "users_id_seq",allocationSize = 1)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String role;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Address address;

}
