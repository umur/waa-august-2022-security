package com.miu.Lab3.service;

import com.miu.Lab3.dto.CategoryDto;
import com.miu.Lab3.entity.Category;

import java.util.List;

public interface CategoryService {
    public List<CategoryDto> findAll();
    public CategoryDto findById(int id);
    public void add(CategoryDto categoryDto);
    public void deleteById(int id);
    public  CategoryDto updateById(int id, CategoryDto categoryDto);
}
