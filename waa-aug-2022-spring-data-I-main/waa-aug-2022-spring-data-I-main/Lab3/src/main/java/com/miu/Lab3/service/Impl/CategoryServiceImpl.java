package com.miu.Lab3.service.Impl;

import com.miu.Lab3.dto.CategoryDto;
import com.miu.Lab3.entity.Category;
import com.miu.Lab3.respository.CategoryRepo;
import com.miu.Lab3.service.CategoryService;
import com.miu.Lab3.utils.MappingUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;

    public ModelMapper getMapper(){
        return  new ModelMapper();
    }
    @Override
    public List<CategoryDto> findAll() {
        var result = new ArrayList<Category>();
        categoryRepo.findAll().forEach(result::add);

        return MappingUtils.mapList(result,CategoryDto.class);
    }

    @Override
    public CategoryDto findById(int id) {
        var result = categoryRepo.findById(id).get();
        return getMapper().map(result,CategoryDto.class);
    }

    @Override
    public void add(CategoryDto categoryDto) {
        Category category = getMapper().map(categoryDto,Category.class);
        categoryRepo.save(category);
    }

    @Override
    public void deleteById(int id) {
        categoryRepo.deleteById(id);
    }

    @Override
    public CategoryDto updateById(int id,CategoryDto categoryDto) {
        Category cat = categoryRepo.findById(id).get();
        Category updatedCat = getMapper().map(categoryDto,Category.class);
        categoryRepo.save(updatedCat);
        return categoryDto;
    }
}
