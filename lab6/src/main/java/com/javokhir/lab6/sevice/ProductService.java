package com.javokhir.lab6.sevice;

import com.javokhir.lab6.annotation.OffensiveValidation;
import com.javokhir.lab6.domain.Product;
import com.javokhir.lab6.dto.ProductDto;
import com.javokhir.lab6.mapper.ProductMapper;
import com.javokhir.lab6.repo.ProductRepo;
import com.javokhir.lab6.sevice.auth.Security;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProductService implements Products {

    private final ProductRepo productRepo;
    private final Security security;

    private final ProductMapper mapper;

    @OffensiveValidation
    @Override
    public ProductDto create(ProductDto productDto) {
        Product product = mapper.fromDto(productDto);
        product.setCreatedBy(security.getCurrentUser());
        return mapper.toDto(productRepo.save(product));
    }

    @Override
    public ProductDto getById(Long id) {
        return mapper.toDto(getProductById(id));
    }

    @Override
    public List<ProductDto> getAll() {
        return productRepo.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    private Product getProductById(Long id) {
        return productRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Entity with id: %s not found", id)));
    }
}
