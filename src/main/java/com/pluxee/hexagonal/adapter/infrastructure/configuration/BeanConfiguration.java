package com.pluxee.hexagonal.adapter.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pluxee.hexagonal.adapter.infrastructure.persistence.ProductRepositoryImpl;
import com.pluxee.hexagonal.adapter.infrastructure.persistence.jpa.ProductRepositoryJpa;
import com.pluxee.hexagonal.adapter.rest.ProductController;
import com.pluxee.hexagonal.core.application.ProductServiceImpl;
import com.pluxee.hexagonal.core.domain.ports.inbound.ProductServiceIn;
import com.pluxee.hexagonal.core.domain.ports.outbound.ProductRepositoryOut;

@Configuration
public class BeanConfiguration {

    @Bean
    ProductRepositoryOut productRepositoryOut(ProductRepositoryJpa productJpa) {
        return new ProductRepositoryImpl(productJpa);
    }

    @Bean
    public ProductServiceIn productServiceIn(ProductRepositoryOut productRepository) {
        return new ProductServiceImpl(productRepository);
    }

    @Bean
    ProductController productController(ProductServiceIn productService) {
        return new ProductController(productService);
    }

}
