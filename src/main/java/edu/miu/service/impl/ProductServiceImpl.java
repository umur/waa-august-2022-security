package edu.miu.service.impl;

import edu.miu.aspect.OffensiveWordCount;
import edu.miu.entity.Product;
import edu.miu.repository.ProductRepository;
import edu.miu.service.ProductService;
import edu.miu.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepo;
    private final SecurityUtils securityUtils;

    @OffensiveWordCount
    @Override
    public void save(String name, double price) {
        Product product = new Product(name, price);
        product.setUser(securityUtils.getCurrentUser());
        productRepo.save(product);
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product getById(int id) {
        return productRepo.findById(id).get();
    }

    public List<Product> getAll() {
        var result = new ArrayList<Product>(productRepo.findAll());
        return result;
    }
}