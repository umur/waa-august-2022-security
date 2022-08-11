package com.example.waaaugust2022security.repository;

import com.example.waaaugust2022security.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
