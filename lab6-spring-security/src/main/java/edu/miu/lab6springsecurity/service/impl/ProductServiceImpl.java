package edu.miu.lab6springsecurity.service.impl;

import edu.miu.lab6springsecurity.dto.ProductDto;
import edu.miu.lab6springsecurity.entity.Product;
import edu.miu.lab6springsecurity.repository.ProductRepo;
import edu.miu.lab6springsecurity.repository.UserRepo;
import edu.miu.lab6springsecurity.service.ProductService;
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

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<ProductDto> findAll() {
        var products = new ArrayList<ProductDto>();
        productRepo.findAll().forEach(p -> products.add(modelMapper.map(p, ProductDto.class)));
        return products;
    }
}
