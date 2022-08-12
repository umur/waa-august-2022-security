package edu.miu.spring_data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User_Table")  // Change the table name User because it's a reserved word and doesn't create the table otherwise
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String firstname;
    private String lastname ;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_user")
    @JsonBackReference
    //@BatchSize(size = 1)
    //@Fetch(FetchMode.JOIN)
    private List<Product> products = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "user" )
    private List<Review> reviews = new ArrayList<>();

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "address_ID")
    private Address address;

    @ManyToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    @JoinTable
    private List<Role> roles ;

    public User(String email, String password, String firstname, String lastname) {
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
