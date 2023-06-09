package com.online.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@JsonIgnoreProperties("itemList")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customers_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> itemList;

    private LocalDateTime dateTime = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private Status status;

    private BigDecimal totalPrice;
    private Boolean paid;

    public Order(List<OrderItem> list, Customer customer, BigDecimal totalPrice) {
        this.customer = customer;
        this.itemList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            itemList.add(list.get(i));
            itemList.get(i).setOrder(this);
        }
        this.paid = false;
        this.status = Status.PENDING;
        this.totalPrice = totalPrice;
    }

    public void markAsPaid() {
        this.paid = true;
        this.status = Status.PROCESSING;
    }
}
