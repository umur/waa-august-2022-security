package miu.edu.lab06.service;

import miu.edu.lab06.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDTO> getAll();
    Optional<ProductDTO> getById(Long id);
    ProductDTO save(ProductDTO user);
    void delete(Long id);
}
