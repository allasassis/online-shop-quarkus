package com.online.controller;

import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/order")
public class OrderController {

    @POST
    @Transactional
    public void insertOrder() {

    }
}
