package com.example.demo.repository;

import com.example.demo.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

    List<Product> findAllByPriceGreaterThan(Double minPrice);

    List<Product> findByCategoryNameAndPriceLessThan(String categoryName, Double maxPrice);

    List<Product> findAllByNameContains(@Param("name") String name);

}
