package com.waa.security.controller;

import com.waa.security.dto.CategoryDto;
import com.waa.security.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable Integer id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public CategoryDto save(@RequestBody CategoryDto categoryDto) {
        return categoryService.save(categoryDto);
    }

    @PutMapping("/{id}")
    public CategoryDto update(@RequestBody CategoryDto categoryDto) {
        return categoryService.update(categoryDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        categoryService.delete(id);
    }
}
