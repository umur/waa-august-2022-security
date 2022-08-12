package edu.miu.spring_data.service.impl;

import edu.miu.spring_data.dto.CategoryDto;

import edu.miu.spring_data.entity.Category;

import edu.miu.spring_data.repository.CategoryRepository;

import edu.miu.spring_data.service.CategoryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelmapper = new ModelMapper();

    @Override
    public List<CategoryDto> findAll() {

        var categories = categoryRepository.findAll();
        var result = new ArrayList<CategoryDto>();

        for(Category category : categories)
        {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto = modelmapper.map(category , CategoryDto.class);
            result.add(categoryDto);
        }
        return result;
    }

    @Override
    public CategoryDto getCategory(int id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if(category != null)
        {
            CategoryDto categoryDto = modelmapper.map(category, CategoryDto.class);
            return categoryDto;
        }

        return null;
    }

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category category = modelmapper.map(categoryDto , Category.class);
        Category c = categoryRepository.save(category);
        CategoryDto cc = modelmapper.map(c , CategoryDto.class);
        return cc;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, int id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if(category != null)
        {
            Category c = modelmapper.map(categoryDto , Category.class);
            Category cc = categoryRepository.save(c);
            CategoryDto cdto = modelmapper.map(cc , CategoryDto.class);
            return cdto;
        }
        return null;
    }


    @Override
    public void deleteCategory(int id) {

        Category category = categoryRepository.findById(id).orElse(null);
        if(category != null)
        {
            categoryRepository.delete(category);
        }

    }
}
