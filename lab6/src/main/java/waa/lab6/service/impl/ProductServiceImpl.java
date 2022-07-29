package waa.lab6.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import waa.lab6.entity.Product;
import waa.lab6.entity.User;
import waa.lab6.repository.ProductRepo;
import waa.lab6.repository.UserRepo;
import waa.lab6.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    private final UserRepo userRepo;

    @Override
    public void save(Product p) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userRepo.findByEmail(userDetails.getUsername());
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

    public List<Product> getAll() {
        var result = new ArrayList<Product>();
        productRepo.findAll().forEach(result::add);
        return result;
    }

}