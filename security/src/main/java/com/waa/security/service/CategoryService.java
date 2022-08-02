package com.waa.security.service;


import com.waa.security.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();
    CategoryDto save(CategoryDto categoryDto);
    CategoryDto findById(int categoryDto);
    CategoryDto update(CategoryDto categoryDto);
    void delete(int id);
}
