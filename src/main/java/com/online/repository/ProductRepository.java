package com.online.repository;

import com.online.model.Category;
import com.online.model.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {

    public boolean productExists(String name, String brand, Category category) {
        return find("name = ?1 and brand = ?2 and category = ?3", name, brand, category).firstResultOptional().isPresent();
    }
}
