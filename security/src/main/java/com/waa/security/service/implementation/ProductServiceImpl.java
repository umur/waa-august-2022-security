package com.waa.security.service.implementation;


import com.waa.security.annotation.AwesomePost;
import com.waa.security.annotation.ExecutionTime;
import com.waa.security.dto.ProductDto;
import com.waa.security.entity.Category;
import com.waa.security.entity.Product;
import com.waa.security.entity.User;
import com.waa.security.exception.ProductNotFoundException;
import com.waa.security.repository.CategoryRepository;
import com.waa.security.repository.ProductRepository;
import com.waa.security.repository.UserRepository;
import com.waa.security.security.MyUserDetails;
import com.waa.security.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private  final UserRepository userRepository;
    private final ModelMapper modelMapper;

    private final CategoryRepository categoryRepository;
    @ExecutionTime
    @AwesomePost
    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream().map(product -> productToDto(product)).collect(Collectors.toList());
    }
    @ExecutionTime
    @Override
    public List<ProductDto> findAllByPriceGreaterThan(double minPrice) {
        return productRepository.findAllByPriceGreaterThan(minPrice).stream().map(product -> productToDto(product)).collect(Collectors.toList());
    }

    @ExecutionTime
    @Override
    public List<ProductDto> findAllByCategoryAndPriceLessThan(int id, double minPrice) {
        Optional<Category> category=categoryRepository.findById(id);
        if(!category.isPresent()){
            return Collections.emptyList();
        }
        return productRepository.findAllByCategoryAndPriceLessThan(category.get(),minPrice).stream().map(product -> productToDto(product)).collect(Collectors.toList());
    }
    @ExecutionTime
    @Override
    public List<ProductDto> findAllByNameContaining(String keyword) {
        return productRepository.findAllByNameContaining(keyword).stream().map(product -> productToDto(product)).collect(Collectors.toList());
    }

    @ExecutionTime
    @Override
    public ProductDto save(ProductDto productDto) {
        Product product=dtoToProduct(productDto);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((MyUserDetails) principal).getUsername();
        User user=userRepository.findByUsername(username);
        product.setUser(user);
        categoryRepository.save(product.getCategory());
        return productToDto(productRepository.save(product));
    }

    @ExecutionTime
    @Override
    public ProductDto findById(int productId) {
        return productToDto(productRepository.findById(productId).orElse(null));
    }

    @ExecutionTime
    @Override
    public ProductDto update(ProductDto productDto) {
        Category category = modelMapper.map(productDto.getCategory(), Category.class);
        Product product=dtoToProduct(productDto);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((MyUserDetails) principal).getUsername();
        User user=userRepository.findByUsername(username);
        product.setUser(user);
        categoryRepository.save(category);
        return productToDto(productRepository.save(product));
    }
    @ExecutionTime
    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    private ProductDto productToDto(Product product) {
        if(product!=null){

            return modelMapper.map(product, ProductDto.class);
        }
        throw new ProductNotFoundException("Product with the given id not found!");
    }

    private Product dtoToProduct(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }
}
