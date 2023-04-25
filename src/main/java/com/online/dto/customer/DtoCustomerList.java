package com.online.dto.customer;

import com.online.model.Customer;

import java.time.LocalDate;

public record DtoCustomerList(String name, String email, LocalDate birthdate) {
    public DtoCustomerList(Customer customer) {
        this(customer.getName(), customer.getEmail(), customer.getBirthdate());
    }
}
