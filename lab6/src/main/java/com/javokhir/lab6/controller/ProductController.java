package com.javokhir.lab6.controller;

import com.javokhir.lab6.dto.ProductDto;
import com.javokhir.lab6.sevice.Products;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private final Products products;

    @GetMapping
    public List<ProductDto> getProducts() {
        return products.getAll();
    }

    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable("id") Long id) {
        return products.getById(id);
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto product) {
        return products.create(product);
    }
}
