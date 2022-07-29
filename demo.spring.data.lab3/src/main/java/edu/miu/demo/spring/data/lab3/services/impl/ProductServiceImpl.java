package edu.miu.demo.spring.data.lab3.services.impl;

import edu.miu.demo.spring.data.lab3.dtos.ProductDto;

import edu.miu.demo.spring.data.lab3.helpers.Helper;
import edu.miu.demo.spring.data.lab3.helpers.HelloWorld;
import edu.miu.demo.spring.data.lab3.helpers.ExecutionTime;
import edu.miu.demo.spring.data.lab3.helpers.AopIsAwesomeHeader;
import edu.miu.demo.spring.data.lab3.models.Product;
import edu.miu.demo.spring.data.lab3.repos.ProductRepo;
import edu.miu.demo.spring.data.lab3.services.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;

    private Helper helper;

   // @HelloWorld
   @ExecutionTime

    @Override
    public List<ProductDto> getAll() {
       var allProducts = productRepo.findAll();
       var products = new ArrayList<ProductDto>();
       allProducts.forEach(product -> products.add(modelMapper.map(product, ProductDto.class)));
       return products;
    }
    @AopIsAwesomeHeader
    @Override
    public void save(ProductDto productDto) {
        var newProduct = modelMapper.map(productDto, Product.class);
        productRepo.save(newProduct);
    }
    public List<ProductDto> getAllProductsPriceGreaterThan(float minPrice){
        var allProducts = productRepo.findProductsByPriceGreaterThan(minPrice);
        var products = new ArrayList<ProductDto>();
        allProducts.forEach(product -> products.add(modelMapper.map(product, ProductDto.class)));
        return products;
    }
    @Override
    public List<ProductDto> getAllProductsByCatAndPriceLessThan(int category, float maxPrice) {
        var allProducts = productRepo.findProductsByCategoryIdAndPriceLessThan(category, maxPrice);
        var products = new ArrayList<ProductDto>();
        allProducts.forEach(product -> products.add(modelMapper.map(product, ProductDto.class)));
        return products;
    }
    @Override
    public List<ProductDto> getAllProductsNameContains(String keyword) {
        var allProducts = productRepo.findProductsByNameContaining(keyword);
        var products = new ArrayList<ProductDto>();
        allProducts.forEach(product -> products.add(modelMapper.map(product, ProductDto.class)));
        return products;
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }
}
