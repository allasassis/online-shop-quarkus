package com.online.service;

import com.online.dto.order.DtoInsertOrder;
import com.online.dto.order.DtoOrderDetailed;
import com.online.dto.order.DtoOrderItem;
import com.online.dto.order.DtoOrderList;
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
import java.math.BigDecimal;
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

    public List<DtoOrderList> findAllOrders() {
        return orderRepository.findAll().list().stream().map(DtoOrderList::new).toList();
    }

    public List<DtoOrderList> findAllOrdersPaid() {
        return orderRepository.findByPaid(true).stream().map(DtoOrderList::new).toList();
    }

    public List<DtoOrderList> findAllOrdersNotPaid() {
        return orderRepository.findByPaid(false).stream().map(DtoOrderList::new).toList();
    }

    public DtoOrderDetailed findOrderById(Long id) {
        Optional<Order> order = Optional.ofNullable(orderRepository.findById(id));
        if(order.isEmpty()) {
            throw new ShopApiException("There's no order with this ID! Try again.");
        }
        return new DtoOrderDetailed(order.get(), conversorToDto(order.get().getItemList()));
    }

    public DtoOrderDetailed insertOrder(DtoInsertOrder dto) {
        Customer customer = verifier(dto);
        List<OrderItem> list = conversorToOrderItem(dto);

        Order order = new Order(list, customer, calculateTotalPrice(list));
        orderRepository.persist(order);

        return new DtoOrderDetailed(order, dto.itemList());
    }

    public DtoOrderDetailed payOrder(Long id) {
        Optional<Order> order = Optional.ofNullable(orderRepository.findById(id));
        if (order.isEmpty()) {
            throw new ShopApiException("This order has expired!");
        }
        order.get().markAsPaid();
        orderRepository.persist(order.get());

        List<DtoOrderItem> dtoList = conversorToDto(order.get().getItemList());
        return new DtoOrderDetailed(order.get(), dtoList);
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
            Optional<Product> product = Optional.ofNullable(productRepository.findByName(dto.itemList().get(i).name()));
            if (product.isEmpty()) {
             throw new ShopApiException("The product: " + dto.itemList().get(i).name() + ", doesn't exist.");
            }
            if (product.get().getQuantity() < dto.itemList().get(i).quantity()) {
                throw new ShopApiException("Product: " + dto.itemList().get(i).name() + ", is out of stock!");
            }
        list.add(new OrderItem(product.get().getName(), product.get().getPrice(), dto.itemList().get(i).quantity()));
        }
        return list;
    }

    private List<DtoOrderItem> conversorToDto(List<OrderItem> list) {
        List<DtoOrderItem> list1 = new ArrayList<>();

        for (OrderItem orderItem: list) {
            list1.add(new DtoOrderItem(orderItem));
        }
        return list1;
    }

    private BigDecimal calculateTotalPrice(List<OrderItem> list) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (int i = 0; i < list.size(); i++) {
            BigDecimal price = BigDecimal.valueOf(list.get(i).getPrice());
            BigDecimal quantity = BigDecimal.valueOf(list.get(i).getQuantity());
            totalPrice = totalPrice.add(quantity.multiply(price));
        }
        return totalPrice;
    }
}
