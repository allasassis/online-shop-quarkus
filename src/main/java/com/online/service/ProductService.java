package com.online.service;

import com.online.dto.product.DtoCreateProduct;
import com.online.dto.product.DtoProductDetailed;
import com.online.dto.product.DtoUpdateProduct;
import com.online.exception.ShopApiException;
import com.online.model.Customer;
import com.online.model.Product;
import com.online.repository.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    public List<Product> listProducts() {
        return productRepository.findAll().list();
    }

    public DtoProductDetailed insertProduct(DtoCreateProduct product) {
        if (productRepository.productExists(product.name(), product.brand(), product.category())) {
            throw new ShopApiException("This product is already registered in our database!");
        }

        productRepository.persist(new Product(product));
        return new DtoProductDetailed(product);
    }

    public DtoProductDetailed updateProduct(DtoUpdateProduct dto, Long id) {
        Product product = verifyIfExist(id);
        product.update(dto);
        productRepository.persist(product);
        return new DtoProductDetailed(product);
    }

    private Product verifyIfExist(Long id) {
        Optional<Product> product = Optional.ofNullable(productRepository.findById(id));
        if (product.isEmpty()) {
            throw new ShopApiException("This ID doesn't exist in our database, try another.");
        }
        return product.get();
    }

    public void deleteProduct(Long id) {
        verifyIfExist(id);
        productRepository.deleteById(id);
    }
}
