package com.waa.security.controller;

import com.waa.security.dto.ProductDto;
import com.waa.security.security.MyUserDetails;
import com.waa.security.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @GetMapping("/filter-by-min-price")
    public List<ProductDto> findAllByPriceGreaterThan(@RequestParam Double minPrice) {
        return productService.findAllByPriceGreaterThan(minPrice);
    }

    @GetMapping("/filter-by-category-max-price")
    public List<ProductDto> findAllByCategoryAndPriceLessThan(@RequestParam int categoryId, @RequestParam Double maxPrice) {
        return productService.findAllByCategoryAndPriceLessThan(categoryId, maxPrice);
    }

    @GetMapping("/filter-by-keyword")
    public List<ProductDto> findAllByNameContaining(@RequestParam String keyword) {
        return productService.findAllByNameContaining(keyword);
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Integer id) {
        return productService.findById(id);
    }

    @PostMapping
    public ProductDto save(@RequestBody ProductDto productDto) {
        return productService.save(productDto);
    }

    @PutMapping("/{id}")
    public ProductDto update(@RequestBody ProductDto productDto) {
        return productService.update(productDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        productService.delete(id);
    }
}
