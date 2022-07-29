package com.waa.lab.service;

import com.waa.lab.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDTO> findAll();
    void save(ProductDTO product);
    void deleteById(Integer id);
    Optional<ProductDTO> findById(Integer id);
    List<ProductDTO> findAllByPriceGreaterThanEqual(Integer minPrice);
    List<ProductDTO> findAllByCategoryAndMaxPrice(Integer category, Integer maxPrice);
    List<ProductDTO> findAllByNameIsLikeIgnoreCase(String keyword);
}
