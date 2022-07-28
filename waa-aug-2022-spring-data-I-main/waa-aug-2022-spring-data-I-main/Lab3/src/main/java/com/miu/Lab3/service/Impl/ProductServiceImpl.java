package com.miu.Lab3.service.Impl;

import com.miu.Lab3.dto.CategoryDto;
import com.miu.Lab3.dto.ProductDto;
import com.miu.Lab3.entity.Product;
import com.miu.Lab3.respository.ProductRepo;
import com.miu.Lab3.service.ProductService;
import com.miu.Lab3.utils.MappingUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<ProductDto> findAll() {
        var result = new ArrayList<Product>();
        productRepo.findAll().forEach(result::add);
        return MappingUtils.mapList(result,ProductDto.class);
    }

    @Override
    public ProductDto findById(int id) {
        return new ModelMapper().map(productRepo.findById(id),ProductDto.class);
    }

    @Override
    public void add(ProductDto productDto) {
        Product product = new ModelMapper().map(productDto,Product.class);
        productRepo.save(product);
    }

    @Override
    public void deleteById(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public ProductDto update(int id, ProductDto productDto) {
        Product productToUpdate = new ModelMapper().map(productDto,Product.class);
        productRepo.save(productToUpdate);
        return productDto;
    }

    @Override
    public List<ProductDto> findAllByPriceGreaterThan(double minPrice) {
        List<Product> products= productRepo.findAllByPriceGreaterThan(minPrice);
        return MappingUtils.mapList(products, ProductDto.class);
    }

    @Override
    public List<Product> findAllByCategoryAndPriceLessThan(double maxPrice) {
        return productRepo.findCategoryByPriceLessThan(maxPrice);
    }

    @Override
    public List<Product> findAllByNameContaining(String keyword) {
        return productRepo.findAllByNameContains(keyword);
    }

    @Override
    public List<Product> findAll_Review_ById(int id) {
        return productRepo.findAll_Review_ById(id);
    }
}
