package cs545waa.lab6.service;

import cs545waa.lab6.entity.Product;
import cs545waa.lab6.model.ProductDto;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product save(ProductDto productDto);
}
