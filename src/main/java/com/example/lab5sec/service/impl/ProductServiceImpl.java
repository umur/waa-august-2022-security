package com.example.lab5sec.service.impl;
import com.example.lab5sec.dto.ProductDto;
import com.example.lab5sec.entity.Product;
import com.example.lab5sec.entity.User;
import com.example.lab5sec.repo.ProductRepo;
import com.example.lab5sec.repo.UserRepo;
import com.example.lab5sec.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private UserRepo userRepo;

    public List<Product> findAllProducts() {
        return (List<Product>) productRepo.findAll();
    }
//    public List<Product> findAllProductsByUserId(int id) {
//        List<Product> products = productRepo.findAllByUserId(id);
//        return products;
//    }

    public Product findProductById(int id) {
        return productRepo.findById(id).get();
    }

    @Override
    public Product createProduct(ProductDto productDto) throws Exception {
        User user = userRepo.findById(productDto.getUserId()).orElse(null);
        if(user ==null) throw new Exception("user not found");

        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setRating(productDto.getRating());
        product.setOwner(user);

        Product savedProduct = productRepo.save(product);

        return savedProduct;
    }

    public Product updateProduct(Product product){
        return productRepo.save(product);
    }

    public void deleteProductById(int id){
        productRepo.deleteById(id);
    }

}
