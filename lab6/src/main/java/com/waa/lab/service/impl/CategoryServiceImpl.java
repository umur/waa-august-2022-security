package com.waa.lab.service.impl;

import com.waa.lab.dto.CategoryDTO;
import com.waa.lab.entity.Category;
import com.waa.lab.repository.CategoryRepository;
import com.waa.lab.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> findAll() {
        var result = new ArrayList<CategoryDTO>();
        categoryRepository.findAll().forEach(item -> {
            result.add(modelMapper.map(item, CategoryDTO.class));
        });
        return result;
    }

    @Override
    public Optional<CategoryDTO> findById(Integer id) {
        return categoryRepository.findById(id).map(item -> modelMapper.map(item, CategoryDTO.class));
    }

    @Override
    public void save(CategoryDTO categoryDTO) {
        categoryRepository.save(modelMapper.map(categoryDTO, Category.class));
    }

    @Override
    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }
}
