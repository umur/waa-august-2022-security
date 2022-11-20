package miu.edu.lab06.dto;

import lombok.Data;
import miu.edu.lab06.aspect.WaaWord;

import java.time.Instant;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private Double price;

    private Instant createdAt;
    private Long createdBy;
    private Instant updatedAt;
    private Long updatedBy;
}
