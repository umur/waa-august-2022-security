package edu.miu.spring_data.controller;

import edu.miu.spring_data.dto.ProductDto;

import edu.miu.spring_data.entity.Product;
import edu.miu.spring_data.entity.Review;
import edu.miu.spring_data.entity.User;
import edu.miu.spring_data.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable int id) {
        return productService.getProduct(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProductDto addProduct(@RequestBody ProductDto productDto ){

        return productService.addProduct(productDto);
    }


    @PutMapping("/{id}")
    public ProductDto updateProduct(@RequestBody ProductDto productDto, @PathVariable int id) {
        return productService.updateProduct(productDto, id);
    }


    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }



    @GetMapping("/reviews")
    public List<Review> findAllReviewsOfProduct(@RequestParam int productId)
    {
        return productService.findAllReviewsOfProduct(productId);
    }

    @GetMapping("/filter")
    public List<Product> findByPriceGreaterThan(@RequestParam double minPrice)
    {
        return productService.findByPriceGreaterThan(minPrice);
    }

    @GetMapping("/search")
    List<Product> findByNameContains(@RequestParam String keyword)
    {
        return productService.findByNameContains(keyword);
    }

    @GetMapping("/filter/{category_id}")
    public List<Product> findByCategoryAndPriceLessThan( @PathVariable int category_id , @RequestParam double maxPrice)
    {
        return productService.findByCategoryAndPriceLessThan(category_id ,maxPrice);
    }
}
