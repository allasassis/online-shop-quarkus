package com.online.dto.order;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record DtoOrdemItem(@NotBlank String name, @NotNull Integer quantity) {
}
