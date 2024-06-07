package com.pluxee.hexagonal.core.application;

import com.pluxee.hexagonal.core.domain.model.Product;
import com.pluxee.hexagonal.core.domain.ports.inbound.ProductServiceIn;
import com.pluxee.hexagonal.core.domain.ports.outbound.ProductRepositoryOut;

public class ProductServiceImpl implements ProductServiceIn {

    private final ProductRepositoryOut productRepository;

    public ProductServiceImpl(
        final ProductRepositoryOut productRepository
    ) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository.create(product);
    }

    @Override
    public Product readOne(Long id) {
        Product product = productRepository.readOne(id);
        if (product == null) {
            // lança uma exception
        }

        return product;
    }
    
}
