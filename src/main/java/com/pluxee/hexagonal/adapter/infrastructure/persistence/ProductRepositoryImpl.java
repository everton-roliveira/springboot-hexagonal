package com.pluxee.hexagonal.adapter.infrastructure.persistence;

import java.util.Optional;

import com.pluxee.hexagonal.adapter.infrastructure.persistence.entity.ProductEntity;
import com.pluxee.hexagonal.adapter.infrastructure.persistence.jpa.ProductRepositoryJpa;
import com.pluxee.hexagonal.adapter.infrastructure.persistence.mapper.ProductMapper;
import com.pluxee.hexagonal.core.domain.model.Product;
import com.pluxee.hexagonal.core.domain.ports.outbound.ProductRepositoryOut;

public class ProductRepositoryImpl implements ProductRepositoryOut {

    private final ProductRepositoryJpa productJpa;

    public ProductRepositoryImpl(
            final ProductRepositoryJpa productJpa) {
        this.productJpa = productJpa;
    }

    @Override
    public Product create(Product product) {
        ProductEntity entity = ProductMapper.productToEntity(product);
        ProductEntity save = productJpa.save(entity);
        return ProductMapper.productEntityToProduct(save);
    }

    @Override
    public Product readOne(Long id) {
        Optional<ProductEntity> entityOptional = productJpa.findById(id);

        if (entityOptional.isPresent()) {
            ProductEntity entity = entityOptional.get();
            return ProductMapper.productEntityToProduct(entity);
        }
        return null;
    }

}
