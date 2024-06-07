package com.pluxee.hexagonal.adapter.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pluxee.hexagonal.adapter.rest.mapper.ProductRestMapper;
import com.pluxee.hexagonal.adapter.rest.request.ProductRequest;
import com.pluxee.hexagonal.adapter.rest.response.ProductResponse;
import com.pluxee.hexagonal.core.domain.model.Product;
import com.pluxee.hexagonal.core.domain.ports.inbound.ProductServiceIn;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    private final ProductServiceIn productService;

    public ProductController(
        final ProductServiceIn productService
    ) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest request) {
        Product product = ProductRestMapper.productRequestToProduct(request);
        Product save = productService.create(product);
        ProductResponse response = ProductRestMapper.productToResponse(save);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

       @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
        Product getProduct = productService.readOne(id);
        ProductResponse response = ProductRestMapper.productToResponse(getProduct);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
}
