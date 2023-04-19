package com.online.dto.product;

import com.online.model.Category;
import com.online.model.Product;

public record DtoProductDetailed(String name, String description, String brand, Double price, Category category, Integer quantity) {
    public DtoProductDetailed(DtoCreateProduct product) {
        this(product.name(), product.description(), product.brand(), product.price(), product.category(), product.quantity());
    }

    public DtoProductDetailed(Product product) {
        this(product.getName(), product.getDescription(), product.getBrand(), product.getPrice(), product.getCategory(), product.getQuantity());
    }
}
