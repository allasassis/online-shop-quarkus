package com.online.model;

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
}
