package com.miu.Lab3.respository;

import com.miu.Lab3.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product,Integer> {
  List<Product> findAllByPriceGreaterThan(double minPrice);
  List<Product> findCategoryByPriceLessThan(double maxPrice);
  List<Product> findAllByNameContains(String keyword);
  List<Product> findAll_Review_ById(int id);
}
