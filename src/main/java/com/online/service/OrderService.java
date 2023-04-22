package com.online.service;

import com.online.dto.order.DtoInsertOrder;
import com.online.dto.order.DtoOrderDetailed;
import com.online.exception.ShopApiException;
import com.online.model.Customer;
import com.online.model.Order;
import com.online.model.OrderItem;
import com.online.model.Product;
import com.online.repository.CustomerRepository;
import com.online.repository.OrderRepository;
import com.online.repository.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OrderService {

    @Inject
    OrderRepository orderRepository;

    @Inject
    CustomerRepository customerRepository;

    @Inject
    ProductRepository productRepository;

    public DtoOrderDetailed insertOrder(DtoInsertOrder dto) {
        Customer customer = verifier(dto);
        List<OrderItem> list = conversorToOrderItem(dto);

        Order order = new Order(list, customer);
        orderRepository.persist(order);
        return new DtoOrderDetailed(order, dto.itemList());
    }

    private Customer verifier(DtoInsertOrder dto) {
        Optional<Customer> customer = Optional.ofNullable(customerRepository.findByEmail(dto.email()));
        if (customer.isEmpty()) {
            throw new ShopApiException("This email doesn't exist!");
        }
        return customer.get();
    }

    private List<OrderItem> conversorToOrderItem(DtoInsertOrder dto) {
        List<OrderItem> list = new ArrayList<>();
        for (int i = 0; i < dto.itemList().size(); i++) {
            Product product = productRepository.findByName(dto.itemList().get(i).name());
            if (product.getQuantity() < dto.itemList().get(i).quantity()) {
                throw new ShopApiException("Product: " + dto.itemList().get(i).name() + ", is out of stock!");
            }
        list.add(new OrderItem(product.getName(), product.getPrice(), product.getQuantity()));
        }
        return list;
    }
}
