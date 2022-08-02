package com.waa.security.repository;

import com.waa.security.entity.Category;
import com.waa.security.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByPriceGreaterThan(Double price);
    List<Product>findAllByCategoryAndPriceLessThan(Category category, double price);
    List<Product> findAllByNameContaining(String keyword);
}
