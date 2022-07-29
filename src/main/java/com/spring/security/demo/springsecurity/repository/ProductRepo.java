package com.spring.security.demo.springsecurity.repository;

import com.spring.security.demo.springsecurity.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {
}
