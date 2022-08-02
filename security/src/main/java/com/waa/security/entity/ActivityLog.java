package com.waa.security.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private LocalDate date;
    private String operation;
    private long duration;

}
