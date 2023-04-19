package com.online.model;

import com.online.dto.product.DtoCreateProduct;
import com.online.dto.product.DtoUpdateProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private String brand;
    private Double price;

    @Enumerated(EnumType.STRING)
    private Category category;

    private Integer quantity;

    public Product(DtoCreateProduct product) {
        this.name = product.name();
        this.description = product.description();
        this.brand = product.brand();
        this.price = product.price();
        this.category = product.category();
        this.quantity = product.quantity();
    }

    public void update(DtoUpdateProduct dto) {
        if (dto.name() != null) {
            this.name = dto.name();
        }
        if (dto.description() != null) {
            this.description = dto.description();
        }
        if (dto.brand() != null) {
            this.brand = dto.brand();
        }
        if (dto.price() != null) {
            this.price = dto.price();
        }
        if (dto.category() != null) {
            this.category = dto.category();
        }
    }
}
