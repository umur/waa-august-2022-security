package com.spring.security.demo.springsecurity.service;

import com.spring.security.demo.springsecurity.entity.Product;

import java.util.List;

public interface ProductService {

    void save(Product p);

    void delete(int id);

    Product getById(int id);

    List<Product> getAll();
}
