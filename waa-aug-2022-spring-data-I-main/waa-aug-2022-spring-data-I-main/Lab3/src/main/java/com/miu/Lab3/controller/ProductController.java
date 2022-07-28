package com.miu.Lab3.controller;

import com.miu.Lab3.dto.ProductDto;
import com.miu.Lab3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll(){

        return ResponseEntity.ok(productService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable int id){
        return ResponseEntity.ok(productService.findById(id));
    }
    @PostMapping
    public ResponseEntity addProduct(@RequestBody ProductDto productDto){
        productService.add(productDto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id){
        productService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable int id,@RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.update(id,productDto));
    }
    @GetMapping("/findAllByMinPrice")
    public ResponseEntity findAllByMinPrice(@RequestParam double minPrice){
        return ResponseEntity.ok(productService.findAllByPriceGreaterThan(minPrice));
    }
    @GetMapping("/findAllByCategoryAndPriceLessThan")
    public ResponseEntity findAllByCategoryAndPriceLessThan(@RequestParam double maxPrice){
        return ResponseEntity.ok(productService.findAllByCategoryAndPriceLessThan(maxPrice));
    }
    @GetMapping("/findAllByNameContaining")
    public ResponseEntity findAllByNameContaining(@RequestParam String keyword){
        return ResponseEntity.ok(productService.findAllByNameContaining(keyword));
    }
    @GetMapping("/findAllReviewById")
    public ResponseEntity findAll_Review_ById(@RequestParam int id){
        return ResponseEntity.ok(productService.findAll_Review_ById(id));
    }

}
