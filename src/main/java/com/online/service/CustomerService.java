package com.online.service;

import com.online.dto.customer.DtoCreateCustomer;
import com.online.dto.customer.DtoCustomerDetailed;
import com.online.dto.customer.DtoCustomerList;
import com.online.dto.customer.DtoUpdateCustomer;
import com.online.exception.ShopApiException;
import com.online.model.Customer;
import com.online.repository.CustomerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CustomerService {

    @Inject
    CustomerRepository customerRepository;

    public List<DtoCustomerList> listCustomers() {
        return customerRepository.findAll().stream().map(DtoCustomerList::new).toList();
    }

    public Customer createCustomer(DtoCreateCustomer dto) {
        if (customerRepository.findByEmail(dto.email()) != null) {
            throw new RuntimeException("This email already exists in our database.");
        }
        Customer customer = new Customer(dto);
        customerRepository.persist(customer);
        return customer;
    }

    public DtoCustomerDetailed updateCustomer(Long id, DtoUpdateCustomer dto) {
        Customer customer = verifyIfExist(id);
        customer.update(dto);
        customerRepository.persist(customer);
        return new DtoCustomerDetailed(customer);
    }

    public void deleteCustomer(Long id) {
        verifyIfExist(id);
        customerRepository.deleteById(id);
    }

    private Customer verifyIfExist(Long id) {
        Optional<Customer> customer = Optional.ofNullable(customerRepository.findById(id));
        if (customer.isEmpty()) {
            throw new ShopApiException("This ID doesn't exist in our database, try another.");
        }
        return customer.get();
    }
}
