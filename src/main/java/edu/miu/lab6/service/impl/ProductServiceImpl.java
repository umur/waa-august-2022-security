package edu.miu.lab6.service.impl;
import edu.miu.lab6.dto.ProductDto;
import edu.miu.lab6.entity.Product;
import edu.miu.lab6.entity.User;
import edu.miu.lab6.repo.ProductRepo;
import edu.miu.lab6.repo.UserRepo;
import edu.miu.lab6.service.ProductService;
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
