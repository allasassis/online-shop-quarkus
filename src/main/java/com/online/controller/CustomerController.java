package com.online.controller;

import com.online.dto.DtoCreateCustomer;
import com.online.model.Customer;
import com.online.service.CustomerService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/customer")
public class CustomerController {

    @Inject
    CustomerService customerService;

    @GET
    public List<Customer> listCustomer() {
        return customerService.listCustomers();
    }

    @POST
    @Transactional
    public Customer createCustomer(DtoCreateCustomer dto) {
        return customerService.createCustomer(dto);
    }
}
