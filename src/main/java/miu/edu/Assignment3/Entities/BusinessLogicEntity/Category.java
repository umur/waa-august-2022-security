package miu.edu.Assignment3.Entities.BusinessLogicEntity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import miu.edu.Assignment3.Entities.BasicEntity.BasicEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@ToString
@Table(name = "category")
public class Category extends BasicEntity {

    private String name;
    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Product> productList;

    public Category(String name) {
        this.name = name;
    }
}
