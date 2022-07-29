package edu.miu.demo.spring.data.lab3.Configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfigurations {
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
