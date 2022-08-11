package miu.edu.Assignment3.DTOs.BuisnessLogicDTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import miu.edu.Assignment3.Entities.BusinessLogicEntity.Product;

import java.util.List;



@Data
@ToString
@NoArgsConstructor
public class CategoryDTO {

    private String name;
    private List<Product> productList;

}
