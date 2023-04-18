package com.online.service;

import com.online.dto.DtoCreateCustomer;
import com.online.model.Customer;
import com.online.repository.CustomerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CustomerService {

    @Inject
    CustomerRepository customerRepository;

    public List<Customer> listCustomers() {
        return customerRepository.findAll().list();
    }

    public Customer createCustomer(DtoCreateCustomer dto) {
        if (customerRepository.findByEmail(dto.email()) != null) {
            throw new RuntimeException("This email already exists in our database.");
        }
        Customer customer = new Customer(dto);
        customerRepository.persist(customer);
        return customer;
    }
}
