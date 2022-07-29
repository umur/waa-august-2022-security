package com.waa.lab.repository;

import com.waa.lab.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAllByPriceGreaterThanEqual(Integer minPrice);
    List<Product> findAllByCategoryIdAndPriceLessThanEqual(Integer category, Integer maxPrice);
    List<Product> findAllByNameContainingIgnoreCase(String keyword);
}
