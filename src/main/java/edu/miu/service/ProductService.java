package edu.miu.service;

import edu.miu.entity.Product;
import edu.miu.model.ProductDto;

import java.util.List;

public interface ProductService {

    void save(String name, double price);

    void delete(int id);

    Product getById(int id);

    List<Product> getAll();
}
