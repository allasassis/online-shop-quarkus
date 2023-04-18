package com.online.model;

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

}
