package com.online.dto;

import com.online.model.Address;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record DtoCreateCustomer(@NotBlank String name, @NotBlank @Email String email, @NotBlank LocalDate birthdate, @NotNull @Valid Address address) {

}
