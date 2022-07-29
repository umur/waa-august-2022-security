package edu.miu.demo.spring.data.lab3.services.impl;

import edu.miu.demo.spring.data.lab3.dtos.CategoryDto;
import edu.miu.demo.spring.data.lab3.models.Category;
import edu.miu.demo.spring.data.lab3.repos.CategoryRepo;
import edu.miu.demo.spring.data.lab3.services.CategoryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;
    private final ModelMapper modelMapper;
    @Override
    public List<CategoryDto> getAll() {
        var allCategories = categoryRepo.findAll();
        var categories = new ArrayList<CategoryDto>();
        allCategories.forEach(category -> categories.add(modelMapper.map(category, CategoryDto.class)));
        return categories;
    }

    @Override
    public void save(CategoryDto categoryDto) {
        Category newCategory = modelMapper.map(categoryDto, Category.class);
        categoryRepo.save(newCategory);
    }

//    @Override
//    public CategoryDto update(CategoryDto categoryDto, int id) {
//        var category = categoryRepo.update(new Category(categoryDto.getId(), categoryDto.getName()),id);
//        return new CategoryDto(category.getId(), category.getName());
//    }


}
