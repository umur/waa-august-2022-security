package edu.miu.demo.spring.data.lab3.Controllers;

import edu.miu.demo.spring.data.lab3.dtos.AddressDto;
import edu.miu.demo.spring.data.lab3.dtos.CategoryDto;
import edu.miu.demo.spring.data.lab3.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> getAllCategories(){
        return categoryService.getAll();
    }

    @PostMapping
    public ResponseEntity addCategory(@RequestBody CategoryDto categoryDto){
        categoryService.save(categoryDto);
        return new ResponseEntity("Added category successfully", HttpStatus.CREATED);
    }
//    @PutMapping("/{id}")
//    public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto categoryDto, @PathVariable int id){
//        var updateCategory = categoryService.update(categoryDto, id);
//        return ResponseEntity.ok(updateCategory);
//    }


}
