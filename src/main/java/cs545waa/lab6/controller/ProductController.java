package cs545waa.lab6.controller;

import cs545waa.lab6.aspect.OffensiveWordChecker;
import cs545waa.lab6.entity.Product;
import cs545waa.lab6.model.ProductDto;
import cs545waa.lab6.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public String getAll() {
        return "all products";
    }

    @OffensiveWordChecker
    @PostMapping
    public Product save(@RequestBody ProductDto productDto) {
        return productService.save(productDto);
    }
}
