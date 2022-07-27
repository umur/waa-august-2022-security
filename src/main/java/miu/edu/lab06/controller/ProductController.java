package miu.edu.lab06.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.lab06.dto.ProductDTO;
import miu.edu.lab06.service.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl service;

    @GetMapping
    public List<ProductDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ProductDTO save(@RequestBody ProductDTO product) {
        return service.save(product);
    }

    @PutMapping("{id}")
    public ProductDTO update(@PathVariable Long id, @RequestBody ProductDTO product) {
        product.setId(id);
        return service.save(product);
    }

    public void delete(Long id) {
        service.delete(id);
    }
}
