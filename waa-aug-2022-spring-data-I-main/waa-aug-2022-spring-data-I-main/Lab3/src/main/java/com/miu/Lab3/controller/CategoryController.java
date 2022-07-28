package com.miu.Lab3.controller;

import com.miu.Lab3.dto.CategoryDto;
import com.miu.Lab3.entity.Category;
import com.miu.Lab3.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll(){

        return ResponseEntity.ok(categoryService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable int id){
        return ResponseEntity.ok(categoryService.findById(id));
    }
    @PostMapping
    public ResponseEntity add(@RequestBody CategoryDto category){
        categoryService.add(category);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id){
        categoryService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.updateById(id,categoryDto));
    }
}
