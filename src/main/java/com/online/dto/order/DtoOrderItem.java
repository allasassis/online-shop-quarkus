package com.online.dto.order;

import com.online.model.OrderItem;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record DtoOrderItem(@NotBlank String name, @NotNull Integer quantity) {
    public DtoOrderItem(OrderItem orderItem) {
        this(orderItem.getName(), orderItem.getQuantity());
    }
}
