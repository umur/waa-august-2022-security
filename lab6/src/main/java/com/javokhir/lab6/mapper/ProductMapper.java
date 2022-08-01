package com.javokhir.lab6.mapper;

import com.javokhir.lab6.domain.Product;
import com.javokhir.lab6.dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface ProductMapper {

    Product fromDto(ProductDto dto);

    ProductDto toDto(Product product);
}
