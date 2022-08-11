package miu.edu.Assignment3.Entities.BusinessLogicEntity;



import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import miu.edu.Assignment3.Entities.BasicEntity.BasicEntity;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@ToString
@Table(name = "product")
public class Product extends BasicEntity {

    private String name;
    private double price;
    private double rating;

    public Product(String name, double price, double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }
}
