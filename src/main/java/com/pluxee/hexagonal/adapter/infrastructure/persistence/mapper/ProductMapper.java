package com.pluxee.hexagonal.adapter.infrastructure.persistence.mapper;

import com.pluxee.hexagonal.adapter.infrastructure.persistence.entity.ProductEntity;
import com.pluxee.hexagonal.core.domain.model.Product;

public class ProductMapper {
    private ProductMapper() {
    }

    public static ProductEntity productToEntity(Product product) {
        return product != null ? ProductEntity.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build() : null;
    }

    public static Product productEntityToProduct(ProductEntity entity) {
        return entity != null ? Product.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .build() : null;
    }
}
