package com.aug.banking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Address extends AbstractEntity{
    private Integer id;
    private String street;

    private Integer houseNumber;

    private Integer zipCode;

    private String city;

    private String country;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
