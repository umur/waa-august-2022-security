package com.miu.Lab3.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue
    private int id;
    private String commit;

    @ManyToOne
    @JsonManagedReference
    private User user;
}
