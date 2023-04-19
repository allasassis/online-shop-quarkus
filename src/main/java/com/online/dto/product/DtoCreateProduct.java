package com.online.dto.product;

import com.online.model.Category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record DtoCreateProduct(@NotBlank String name, @NotBlank String description, @NotBlank String brand, @NotNull Double price,@NotNull Category category,@NotNull Integer quantity) {
}
