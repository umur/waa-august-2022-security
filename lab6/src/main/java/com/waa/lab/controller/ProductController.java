package com.waa.lab.controller;

import com.waa.lab.aop.WaaOffensiveWords;
import com.waa.lab.dto.ProductDTO;
import com.waa.lab.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    List<ProductDTO> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    Optional<ProductDTO> findById(@PathVariable Integer id) {
        return productService.findById(id);
    }


    @WaaOffensiveWords(fieldNames = {"name"})
    @PostMapping()
    void save( @RequestBody ProductDTO product) {
        productService.save(product);
    }

    @PutMapping("/{id}")
    void update(@RequestBody ProductDTO product) {
        productService.save(product);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Integer id) {
        productService.deleteById(id);
    }

    @GetMapping("/findAllByMinPrice")
    List<ProductDTO> findAllByPriceGreaterThanEqual(@RequestParam Integer minPrice) {
        return productService.findAllByPriceGreaterThanEqual(minPrice);
    }

    @GetMapping("/findAllByCategoryAndMaxPrice")
    List<ProductDTO> findAllByCategoryContainsAndPriceLessThanEqual(@RequestParam Integer category, @RequestParam Integer maxPrice) {
        return productService.findAllByCategoryAndMaxPrice(category, maxPrice);
    }


    @GetMapping("/findAllByName")
    List<ProductDTO> findAllByNameIsLikeIgnoreCase(@RequestParam String keyword) {
        return productService.findAllByNameIsLikeIgnoreCase(keyword);
    }
}
