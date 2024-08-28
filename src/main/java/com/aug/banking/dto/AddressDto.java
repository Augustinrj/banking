package com.aug.banking.dto;

import com.aug.banking.model.Address;
import com.aug.banking.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private String street;

    private Integer houseNumber;

    private Integer zipCode;

    private String city;

    private String country;

    private Integer userId;

    public AddressDto fromEntity(Address address) {
        return AddressDto.builder()
                .street(address.getStreet())
                .houseNumber(address.getHouseNumber())
                .zipCode(address.getZipCode())
                .city(address.getCity())
                .country(address.getCountry())
                .userId(address.getUser().getId())
                .build();
    }

    public Address toEntity(AddressDto address) {
        return Address.builder()
                .street(address.getStreet())
                .houseNumber(address.getHouseNumber())
                .zipCode(address.getZipCode())
                .city(address.getCity())
                .country(address.getCountry())
                .user(
                        User.builder().id(address.userId).build()
        )
                .build();
    }
}
