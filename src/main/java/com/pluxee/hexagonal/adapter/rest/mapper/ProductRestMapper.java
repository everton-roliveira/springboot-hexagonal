package com.pluxee.hexagonal.adapter.rest.mapper;

import com.pluxee.hexagonal.adapter.rest.request.ProductRequest;
import com.pluxee.hexagonal.adapter.rest.response.ProductResponse;
import com.pluxee.hexagonal.core.domain.model.Product;

public class ProductRestMapper {
    private ProductRestMapper() {
    }

    public static ProductResponse productToResponse(Product product) {
        return product != null ? ProductResponse.builder()
                .id(product.getId())
                .nome(product.getName())
                .preco(product.getPrice())
                .build() : null;
    }

    public static Product productRequestToProduct(ProductRequest request) {
        return request != null ? Product.builder()
                .name(request.getNome())
                .price(request.getPreco())
                .build() : null;
    }
}
