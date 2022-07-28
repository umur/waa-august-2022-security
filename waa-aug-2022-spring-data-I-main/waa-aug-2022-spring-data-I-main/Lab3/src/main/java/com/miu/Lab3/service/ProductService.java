package com.miu.Lab3.service;

import com.miu.Lab3.dto.CategoryDto;
import com.miu.Lab3.dto.ProductDto;
import com.miu.Lab3.entity.Product;

import java.util.List;

public interface ProductService {
    public List<ProductDto> findAll();
    public ProductDto findById(int id);
    public void add(ProductDto productDto);
    public void deleteById(int id);
    public ProductDto update(int id, ProductDto productDto);
    public List<ProductDto> findAllByPriceGreaterThan(double minPrice);
    List<Product> findAllByCategoryAndPriceLessThan(double maxPrice);
    List<Product> findAllByNameContaining(String keyword);
    List<Product> findAll_Review_ById(int id);
}
