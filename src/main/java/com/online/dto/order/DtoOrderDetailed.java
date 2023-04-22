package com.online.dto.order;

import com.online.model.Order;
import com.online.model.Status;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public record DtoOrderDetailed(String email, String name, List<DtoOrdemItem> itemList, LocalDateTime dateTime, Status status) {

    public DtoOrderDetailed(Order order, List<DtoOrdemItem> dtoOrdemItems) {
        this(order.getCustomer().getEmail(), order.getCustomer().getName(), dtoOrdemItems, order.getDateTime(), order.getStatus());
    }
}
