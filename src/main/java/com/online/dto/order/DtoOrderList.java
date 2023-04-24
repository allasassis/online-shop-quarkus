package com.online.dto.order;

import com.online.model.Order;
import com.online.model.Product;
import com.online.model.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DtoOrderList(String email, LocalDateTime dateTime, BigDecimal totalPrice, Status status) {

    public DtoOrderList(Order order) {
        this(order.getCustomer().getEmail(), order.getDateTime(), order.getTotalPrice(), order.getStatus());
    }
}
