package miu.edu.Assignment3.DTOs.BuisnessLogicDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ProductDTO  {
    private String name;
    private double price;
    private double rating;
}
