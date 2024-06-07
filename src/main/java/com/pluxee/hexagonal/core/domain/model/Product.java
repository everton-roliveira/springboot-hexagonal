package com.pluxee.hexagonal.core.domain.model;

import java.math.BigDecimal;

import lombok.Builder;

@Builder
public class Product {
    private Long id;
    private String name;
    private BigDecimal price;

    // Acesso
    public Product() {}

    public Product(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
