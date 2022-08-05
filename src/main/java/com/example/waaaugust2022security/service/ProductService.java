package com.example.waaaugust2022security.service;


import com.example.waaaugust2022security.entity.Product;

import java.util.List;

public interface ProductService {

    void save(Product p);

    void delete(int id);

    Product getById(int id);

    List<Product> getAll();
}
