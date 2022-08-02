package edu.miu.lab5.service.impl;

import edu.miu.lab5.dto.ProductDto;
import edu.miu.lab5.entity.Product;
import edu.miu.lab5.entity.User;
import edu.miu.lab5.repository.ProductRepo;
import edu.miu.lab5.security.AwesomeUserDetails;
import edu.miu.lab5.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Override
    public void save(Product p) {
        var object = (AwesomeUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var user = new User();
        user.setId(object.getId());
        p.setUser(user);
        productRepo.save(p);
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product getById(int id) {
        return productRepo.findById(id).get();
    }

    public List<ProductDto> getAll() {
        ModelMapper modelMapper = new ModelMapper();
        var result = new ArrayList<ProductDto>();
        productRepo.findAll().forEach(product -> result.add(modelMapper.map(product, ProductDto.class)));
        return result;
//        var result = new ArrayList<Product>();
//        productRepo.findAll().forEach(result::add);
//        return result;
    }
}
