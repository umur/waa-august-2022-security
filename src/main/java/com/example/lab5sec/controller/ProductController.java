package com.example.lab5sec.controller;

import com.example.lab5sec.dto.ProductDto;
import com.example.lab5sec.entity.Product;
import com.example.lab5sec.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("")
    public List<Product> findAllProducts(){
        return productService.findAllProducts();
    }

//    @GetMapping("/products/{id}")
//    public List<Product> findAllProductsByUserId(@PathVariable(name = "id") int userId){
//        return productService.findAllProductsByUserId(userId);
//    }

    @PostMapping("")
    public Product createProduct(@RequestBody ProductDto productDto) throws Exception {
        return productService.createProduct(productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) throws Exception {
        productService.deleteProductById(id);
    }

//    @PutMapping("/product")
//    public Product updateProduct(@RequestBody ProductDto product) throws Exception {
//        return productService.updateProduct(product);
//    }

}
