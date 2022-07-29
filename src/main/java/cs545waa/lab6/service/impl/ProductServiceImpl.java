package cs545waa.lab6.service.impl;

import cs545waa.lab6.entity.Product;
import cs545waa.lab6.entity.User;
import cs545waa.lab6.model.ProductDto;
import cs545waa.lab6.repo.ProductRepo;
import cs545waa.lab6.repo.UserRepo;
import cs545waa.lab6.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final UserRepo userRepo;

    public Product save(ProductDto productDto) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return productRepo.save(new Product(0, productDto.getName(), userRepo.findByUsername(userDetails.getUsername())));
    }

    public List<Product> getAll() {
        var result = new ArrayList<Product>();
        productRepo.findAll().forEach(result::add);
        return result;
    }
}
