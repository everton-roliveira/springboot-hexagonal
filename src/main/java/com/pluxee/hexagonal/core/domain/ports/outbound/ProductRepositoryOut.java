package com.pluxee.hexagonal.core.domain.ports.outbound;

import com.pluxee.hexagonal.core.domain.model.Product;

public interface ProductRepositoryOut {
    Product create(Product product);
    Product readOne(Long id);
}
