package com.online.controller;

import com.online.dto.order.DtoInsertOrder;
import com.online.dto.order.DtoOrderDetailed;
import com.online.service.OrderService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/order")
public class OrderController {

    @Inject
    OrderService orderService;

    @POST
    @Transactional
    public DtoOrderDetailed insertOrder(DtoInsertOrder dtoOrder) {
        return orderService.insertOrder(dtoOrder);
    }
}
