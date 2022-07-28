package edu.miu.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Offense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private Date createdDate;
    @ManyToOne
    private User user;

    public Offense(String description, Date createdDate, User user) {
        this.createdDate = createdDate;
        this.description = description;
        this.user = user;
    }
}
