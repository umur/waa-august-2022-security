package com.waa.lab.controller;

import com.waa.lab.dto.CategoryDTO;
import com.waa.lab.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    List<CategoryDTO> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    Optional<CategoryDTO> findById(@PathVariable Integer id) {
        return categoryService.findById(id);
    }

    @PostMapping()
    void save(@RequestBody CategoryDTO categoryDTO) {
        categoryService.save(categoryDTO);
    }

    @PutMapping("/{id}")
    void update(@RequestBody CategoryDTO categoryDTO) {
        categoryService.save(categoryDTO);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Integer id) {
        categoryService.deleteById(id);
    }

}
