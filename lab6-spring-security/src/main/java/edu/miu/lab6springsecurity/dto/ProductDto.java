package edu.miu.lab6springsecurity.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.miu.lab6springsecurity.entity.Category;
import edu.miu.lab6springsecurity.entity.Review;
import edu.miu.lab6springsecurity.entity.User;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
public class ProductDto {
    private int id;

    private String name;
    private float price;
}
