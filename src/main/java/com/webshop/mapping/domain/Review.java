package com.webshop.mapping.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
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
