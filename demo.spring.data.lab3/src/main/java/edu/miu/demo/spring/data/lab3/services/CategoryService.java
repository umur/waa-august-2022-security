package edu.miu.demo.spring.data.lab3.services;

import edu.miu.demo.spring.data.lab3.dtos.CategoryDto;
import edu.miu.demo.spring.data.lab3.models.Category;

import java.util.List;

public interface CategoryService {
    public List<CategoryDto> getAll();
    public void save(CategoryDto categoryDto);
//    public CategoryDto update(CategoryDto categoryDto,int id);


}
