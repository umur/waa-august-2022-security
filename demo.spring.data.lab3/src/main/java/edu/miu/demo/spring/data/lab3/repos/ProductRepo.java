package edu.miu.demo.spring.data.lab3.repos;

import edu.miu.demo.spring.data.lab3.dtos.ProductDto;
import edu.miu.demo.spring.data.lab3.models.Product;
import edu.miu.demo.spring.data.lab3.models.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {
    public List<Product> findProductsByPriceGreaterThan(float minPrice);
    public List<Product> findProductsByCategoryIdAndPriceLessThan(int category ,float maxPrice);
    public List<Product> findProductsByNameContaining(String keyword);
}
