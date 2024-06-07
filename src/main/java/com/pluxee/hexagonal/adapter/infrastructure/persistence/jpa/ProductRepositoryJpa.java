package com.pluxee.hexagonal.adapter.infrastructure.persistence.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pluxee.hexagonal.adapter.infrastructure.persistence.entity.ProductEntity;

public interface ProductRepositoryJpa extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findById(Long id);
}
