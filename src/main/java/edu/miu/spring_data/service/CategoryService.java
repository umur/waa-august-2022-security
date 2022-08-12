package edu.miu.spring_data.service;

import edu.miu.spring_data.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll ();
    CategoryDto getCategory(int id);
    CategoryDto addCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto , int id);
    void deleteCategory(int id);
}
