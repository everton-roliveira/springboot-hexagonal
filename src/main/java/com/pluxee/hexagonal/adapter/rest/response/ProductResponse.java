package com.pluxee.hexagonal.adapter.rest.response;

import java.math.BigDecimal;

import lombok.Builder;

@Builder
public class ProductResponse {
    private Long id;
    private String nome;
    private BigDecimal preco;

    public ProductResponse() {}

    public ProductResponse(Long id, String nome, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}

