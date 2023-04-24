package com.online.dto.order;

import com.online.model.Order;
import com.online.model.Product;
import com.online.model.Status;

import java.time.LocalDateTime;

public record DtoOrderList(String email, LocalDateTime dateTime, Status status) {

    public DtoOrderList(Order order) {
        this(order.getCustomer().getEmail(), order.getDateTime(), order.getStatus());
    }
}
