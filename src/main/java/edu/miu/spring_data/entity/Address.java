package edu.miu.spring_data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private int zip;
    private String city;

    @JsonBackReference
    @OneToOne(mappedBy = "address")
    private User user ;

    public Address(String street, int zip, String city) {
        this.street = street;
        this.zip = zip;
        this.city = city;

    }


}
