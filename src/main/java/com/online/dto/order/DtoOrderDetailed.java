package com.online.dto.order;

import com.online.model.Order;
import com.online.model.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record DtoOrderDetailed(String email, String name, List<DtoOrderItem> itemList, LocalDateTime dateTime, BigDecimal totalPrice, Boolean paid, Status status) {

    public DtoOrderDetailed(Order order, List<DtoOrderItem> dtoOrderItems) {
        this(order.getCustomer().getEmail(), order.getCustomer().getName(), dtoOrderItems, order.getDateTime(), order.getTotalPrice(), order.getPaid(), order.getStatus());
    }
}
