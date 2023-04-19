package com.online.model;

import com.online.dto.customer.DtoCreateCustomer;
import com.online.dto.customer.DtoUpdateCustomer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private LocalDate birthdate;
    @Embedded
    private Address address;

    public Customer(DtoCreateCustomer dto) {
        this.name = dto.name();
        this.email = dto.email();
        this.birthdate = dto.birthdate();
        this.address = dto.address();
    }

    public void update(DtoUpdateCustomer dto) {
        if (dto.email() != null) {
            this.email = dto.email();
        }
        if (dto.address() != null) {
            this.address.update(dto);
        }
    }
}
