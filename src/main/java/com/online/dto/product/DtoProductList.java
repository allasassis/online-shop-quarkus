package com.online.dto.product;

import com.online.model.Product;

public record DtoProductList(String name, Double price) {
    public DtoProductList(Product product) {
        this(product.getName(), product.getPrice());
    }
}
