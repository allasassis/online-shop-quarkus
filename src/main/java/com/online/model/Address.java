package com.online.model;

import com.online.dto.customer.DtoUpdateCustomer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Embeddable
public class Address {

    private String street;
    private Integer number;
    private String city;
    private String state;
    private Integer zipCode;
    private String country;

    public void update(DtoUpdateCustomer dto) {
        if (dto.address().street != null) {
            this.street = dto.address().street;
        }
        if (dto.address().number != null) {
            this.number = dto.address().number;
        }
        if (dto.address().city != null) {
            this.city = dto.address().city;
        }
        if (dto.address().state != null) {
            this.state = dto.address().state;
        }
        if (dto.address().zipCode != null) {
            this.zipCode = dto.address().zipCode;
        }
        if (dto.address().country != null) {
            this.country = dto.address().country;
        }
    }
}
