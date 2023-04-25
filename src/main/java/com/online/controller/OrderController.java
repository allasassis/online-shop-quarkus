package com.online.controller;

import com.online.dto.order.DtoInsertOrder;
import com.online.dto.order.DtoOrderDetailed;
import com.online.dto.order.DtoOrderList;
import com.online.service.OrderService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.List;

@Path("/order")
public class OrderController {

    @Inject
    OrderService orderService;

    @GET
    public List<DtoOrderList> listAllOrders() {
        return orderService.findAllOrders();
    }

    @GET
    @Path("/paid")
    public List<DtoOrderList> listAllOrdersPaid() {
        return orderService.findAllOrdersPaid();
    }

    @GET
    @Path("/notpaid")
    public List<DtoOrderList> listAllOrdersNotPaid() {
        return orderService.findAllOrdersNotPaid();
    }

    @GET
    @Path("/{orderId}")
    public DtoOrderDetailed findOrderById(@PathParam("orderId") Long id) {
        return orderService.findOrderById(id);
    }

    @POST
    @Transactional
    public DtoOrderDetailed insertOrder(DtoInsertOrder dtoOrder) {
        return orderService.insertOrder(dtoOrder);
    }

    @PUT
    @Path("/payment/{orderId}")
    @Transactional
    public DtoOrderDetailed payOrder(@PathParam("orderId") Long id) {
        return orderService.payOrder(id);
    }
}
