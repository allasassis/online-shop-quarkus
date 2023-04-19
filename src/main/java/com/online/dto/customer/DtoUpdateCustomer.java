package com.online.dto.customer;

import com.online.model.Address;

import javax.validation.Valid;
import javax.validation.constraints.Email;

public record DtoUpdateCustomer(@Email String email, @Valid Address address) {
}
