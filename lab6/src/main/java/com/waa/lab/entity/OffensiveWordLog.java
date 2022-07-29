package com.waa.lab.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Data
public class OffensiveWordLog {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String word;
    @OneToOne
    private User user;

    @CreationTimestamp
//    @CreatedDate
    private ZonedDateTime time;
}
