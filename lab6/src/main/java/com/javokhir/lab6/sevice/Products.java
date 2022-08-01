package com.javokhir.lab6.sevice;

import com.javokhir.lab6.dto.ProductDto;

import java.util.List;

public interface Products {

    ProductDto create(ProductDto product);

    ProductDto getById(Long id);

    List<ProductDto> getAll();

}
