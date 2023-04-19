package com.online.dto;

import com.online.model.Address;
import com.online.model.Customer;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record DtoCustomerDetailed(String name, String email, LocalDate birthdate, @Valid Address address) {
    public DtoCustomerDetailed(Customer customer) {
        this(customer.getName(), customer.getEmail(), customer.getBirthdate(), customer.getAddress());
    }
}
