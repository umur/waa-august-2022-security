package edu.miu.demo.spring.data.lab3.services;

import edu.miu.demo.spring.data.lab3.dtos.ProductDto;
import edu.miu.demo.spring.data.lab3.dtos.ReviewDto;

import java.util.List;

public interface ProductService {
    public List<ProductDto> getAll();

    public List<ProductDto> getAllProductsPriceGreaterThan(float minPrice);
    public List<ProductDto> getAllProductsByCatAndPriceLessThan(int category, float maxPrice);
    public List<ProductDto> getAllProductsNameContains(String keyword);
    public void save(ProductDto productDto);
    public void delete(int id);
}
