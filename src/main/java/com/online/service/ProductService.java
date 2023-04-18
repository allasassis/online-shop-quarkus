package com.online.service;

import com.online.model.Product;
import com.online.repository.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    public List<Product> listProducts() {
        return productRepository.findAll().list();
    }
}
