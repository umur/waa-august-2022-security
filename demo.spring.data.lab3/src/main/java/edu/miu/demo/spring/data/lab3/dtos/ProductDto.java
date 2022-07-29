package edu.miu.demo.spring.data.lab3.dtos;

import edu.miu.demo.spring.data.lab3.models.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private int id;
    private String name;
    private float price;
    private int categoryId;
    private String categoryName;
}
