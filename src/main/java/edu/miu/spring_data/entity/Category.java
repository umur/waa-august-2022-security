package edu.miu.spring_data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  int id;
    private String name;

    @OneToMany
    @JoinColumn(name = "Category_ID")
    @JsonBackReference
    private List<Product> products = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }
}
