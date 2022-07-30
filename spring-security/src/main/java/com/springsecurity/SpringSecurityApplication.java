package com.springsecurity;

import com.springsecurity.domain.AppUser;
import com.springsecurity.domain.Product;
import com.springsecurity.domain.Role;
import com.springsecurity.service.AppUserService;
import com.springsecurity.service.ProductService;
import com.springsecurity.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner run(AppUserService appUserService,
                          RoleService roleService,
                          ProductService productService){
        return args -> {
            roleService.save(new Role(null, "ADMIN"));
            roleService.save(new Role(null, "USER"));

            List<Role> rolesList1 = new ArrayList<>();
            rolesList1.add(roleService.getRoleByName("ADMIN"));

            List<Role> rolesList2 = new ArrayList<>();
            rolesList2.add(roleService.getRoleByName("USER"));

            appUserService.save(new AppUser(null, "Tom Hanks", "hanks", "123", rolesList1));
            appUserService.save(new AppUser(null, "Tom Holland", "holland", "123", rolesList2));

            productService.save(new Product(null, "Car"));
            productService.save(new Product(null, "House"));
            productService.save(new Product(null, "Plane"));
            productService.save(new Product(null, "Yacht"));
            productService.save(new Product(null, "Villa"));


        };
    }
}
