package edu.miu.lab6springsecurity.service;

import edu.miu.lab6springsecurity.dto.ProductDto;
import edu.miu.lab6springsecurity.entity.Product;

import java.util.List;

public interface ProductService {
    public List<ProductDto> findAll();
}
