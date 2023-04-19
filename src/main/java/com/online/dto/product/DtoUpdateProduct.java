package com.online.dto.product;

import com.online.model.Category;

public record DtoUpdateProduct(String name, String description, String brand, Double price, Category category) {
}
