package com.online.controller;

import com.online.dto.customer.DtoCreateCustomer;
import com.online.dto.customer.DtoCustomerDetailed;
import com.online.dto.customer.DtoUpdateCustomer;
import com.online.model.Customer;
import com.online.service.CustomerService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
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

    @PUT
    @Path("/{customerId}")
    @Transactional
    public DtoCustomerDetailed updateCustomer(@PathParam("customerId") Long id, DtoUpdateCustomer dto) {
        return customerService.updateCustomer(id, dto);
    }

    @DELETE
    @Path("/{customerId}")
    @Transactional
    public void deleteCustomer(@PathParam("customerId") Long customerId) {
        customerService.deleteCustomer(customerId);
    }
}
