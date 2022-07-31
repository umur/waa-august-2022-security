package com.example.lab5sec.service;

import com.example.lab5sec.dto.ProductDto;
import com.example.lab5sec.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAllProducts();
    //public Product findProductById(int id);
    public Product createProduct(ProductDto productDto) throws Exception;
    //public Product updateProduct(Product product);
    public void deleteProductById(int id);

}
