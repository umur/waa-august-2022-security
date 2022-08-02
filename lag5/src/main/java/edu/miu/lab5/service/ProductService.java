package edu.miu.lab5.service;


import edu.miu.lab5.dto.ProductDto;
import edu.miu.lab5.entity.Product;

import java.util.List;

public interface ProductService {

    void save(Product p);

    void delete(int id);

    Product getById(int id);

    List<ProductDto> getAll();
}
