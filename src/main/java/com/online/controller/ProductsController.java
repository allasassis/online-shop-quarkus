package com.online.controller;

import com.online.dto.DtoCreateCustomer;
import com.online.model.Customer;
import com.online.model.Product;
import com.online.service.CustomerService;
import com.online.service.ProductService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/product")
public class ProductsController {

    @Inject
    ProductService productService;

    @GET
    public List<Product> listProduct() {
        return productService.listProducts();
    }
}
