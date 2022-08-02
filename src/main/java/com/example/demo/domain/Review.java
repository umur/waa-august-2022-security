package com.example.demo.domain;

import lombok.Data;

import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator",  sequenceName = "review_id_seq",allocationSize = 1)
    private Long id;

    private String comment;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;
}
