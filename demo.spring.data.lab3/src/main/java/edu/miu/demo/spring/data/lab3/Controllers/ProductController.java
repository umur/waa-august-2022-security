package edu.miu.demo.spring.data.lab3.Controllers;

import edu.miu.demo.spring.data.lab3.dtos.CategoryDto;
import edu.miu.demo.spring.data.lab3.dtos.ProductDto;
import edu.miu.demo.spring.data.lab3.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getAllProducts(){
        return productService.getAll();
    }

    @GetMapping("/findByMinPrice")
    public List<ProductDto> getAllProductsPriceGreaterThan(@RequestParam String minPrice){
        return productService.getAllProductsPriceGreaterThan(Float.parseFloat(minPrice));
    }

    @GetMapping("/findByCatAndMaxPrice")
    public List<ProductDto> findProductsByCategoryAndPriceLessThan(@RequestParam String category, @RequestParam String maxPrice){
        return productService.getAllProductsByCatAndPriceLessThan(Integer.parseInt(category), Float.parseFloat(maxPrice));
    }

    @GetMapping("/findByNameContains")
    public List<ProductDto> findProductsByCategoryAndPriceLessThan(@RequestParam String keyword){
        return productService.getAllProductsNameContains(keyword);
    }

    @PostMapping
    public ResponseEntity addProduct(@RequestBody ProductDto productDto){
        productService.save(productDto);
        return new ResponseEntity("Added product successfully", HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity deleteProduct(@RequestParam String id){
        productService.delete(Integer.parseInt(id));
        return new ResponseEntity("Deleted product",HttpStatus.NO_CONTENT);
    }

}
