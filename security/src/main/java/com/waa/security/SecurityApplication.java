package com.waa.security;

import com.waa.security.entity.Role;
import com.waa.security.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NamingConventions;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SecurityApplication {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
        return modelMapper;
    }

    @Bean
    public CommandLineRunner demoData(RoleRepository repo) {
        return args -> {
            List<Role> roles = repo.findAll();
            if (roles.stream().count() == 0) {
                Role role1 = new Role();
                Role role2 = new Role();
                Role role3 = new Role();
                role1.setName("ROLE_CLIENT");
                role2.setName("ROLE_MODERATOR");
                role3.setName("ROLE_ADMIN");
                repo.save(role1);
                repo.save(role2);
                repo.save(role3);
            }

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

}
