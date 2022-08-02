package security.lab6.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import security.lab6.dto.ProductDTO;
import security.lab6.entity.Review;
import security.lab6.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void save(@RequestBody ProductDTO p) throws Exception {
        productService.save(p);
    }

    @GetMapping
    public List<ProductDTO> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable int id) {
        var product = productService.getById(id);
        return ResponseEntity.ok(product);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int productId) {
        //call service
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<Review> getReviewsByProductId(@PathVariable int id) {
        // for demo purposes, this request is not authorized.
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }

}
