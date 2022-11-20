package com.springsecurity.service.impl;

import com.springsecurity.domain.AppUser;
import com.springsecurity.domain.Product;
import com.springsecurity.repository.AppUserRepository;
import com.springsecurity.repository.ProductRepository;
import com.springsecurity.service.AppUserService;
import com.springsecurity.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final AppUserRepository appUserRepository;

    @Override
    public Collection<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product get(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        String loggedInUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<AppUser> appUser = appUserRepository.findByUsername(loggedInUsername);
        if (appUser.isPresent()) {
            product.setAppUser(appUser.get());
        } else {
            throw new UsernameNotFoundException("User not found in database");
        }
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
