package com.online.service;

import com.online.dto.order.DtoInsertOrder;
import com.online.dto.order.DtoOrderDetailed;
import com.online.exception.ShopApiException;
import com.online.model.Customer;
import com.online.model.Order;
import com.online.repository.CustomerRepository;
import com.online.repository.OrderRepository;
import com.online.repository.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
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
        Order order = new Order(dto, customer);
        orderRepository.persist(order);
        return new DtoOrderDetailed(order);
    }

    private Customer verifier(DtoInsertOrder dto) {
        Optional<Customer> customer = Optional.ofNullable(customerRepository.findByEmail(dto.email()));
        if (customer.isEmpty()) {
            throw new ShopApiException("This email doesn't exist!");
        }

        for (int i = 0; i < dto.itemList().size(); i++) {
            if (productRepository.quantityIsLower(dto.itemList().get(i))) {
                throw new ShopApiException("Product #" + dto.itemList().get(i).getName() + " is out of stock!");
            }
        }
        return customer.get();
    }
}
