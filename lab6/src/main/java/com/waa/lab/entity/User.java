package com.waa.lab.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "`user`")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(unique=true)
    private String email;
    private String password;
    private String firstName;
    private String lastName;

//    @JoinColumn(name = "address_id")
//    @OneToOne(mappedBy = "user")
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;
}
