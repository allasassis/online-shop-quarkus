package com.online.controller;

import com.online.dto.product.DtoCreateProduct;
import com.online.dto.product.DtoProductDetailed;
import com.online.dto.product.DtoUpdateProduct;
import com.online.model.Product;
import com.online.service.ProductService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.List;

@Path("/product")
public class ProductController {

    @Inject
    ProductService productService;

    @GET
    public List<Product> listProduct() {
        return productService.listProducts();
    }

    @POST
    @Transactional
    public DtoProductDetailed insertProduct(DtoCreateProduct product) {
        return productService.insertProduct(product);
    }

    @PUT
    @Path("/{productId}")
    @Transactional
    public DtoProductDetailed updateProduct(@PathParam("productId") Long productId, DtoUpdateProduct dto) {
        return productService.updateProduct(dto, productId);
    }

    @DELETE
    @Path("/{productId}")
    @Transactional
    public void deleteProduct(@PathParam("productId") Long id) {
        productService.deleteProduct(id);
    }
}
