package com.pluxee.hexagonal.adapter.rest.request;

import java.math.BigDecimal;

import lombok.Builder;

@Builder
public class ProductRequest {
    private String nome;
    private BigDecimal preco;

    public ProductRequest() {}

    public ProductRequest(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
