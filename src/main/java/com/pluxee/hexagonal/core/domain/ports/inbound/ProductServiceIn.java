package com.pluxee.hexagonal.core.domain.ports.inbound;

import com.pluxee.hexagonal.core.domain.model.Product;

public interface ProductServiceIn {
    Product create(Product product);
    Product readOne(Long id);
}
