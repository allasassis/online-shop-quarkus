package com.online.dto.order;

import com.online.model.Order;

public record DtoOrderDetailed(String email, String name, ) {

    public DtoOrderDetailed(Order order) {

    }
}
