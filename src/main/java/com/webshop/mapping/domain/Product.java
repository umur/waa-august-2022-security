package com.webshop.mapping.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator",  sequenceName = "product_id_seq",allocationSize = 1)
    private Long id;

    private String name;

    private double price;

    private Double rating;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "created_by")
    private User user;
}
