package com.aug.banking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractEntity{

    private String lastname;

    private String firstname;

    private String email;

    private String password;

    private boolean active;
    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;
    @OneToMany(mappedBy = "user")
    List<Contact> contacts;

    @OneToOne
    Account account;

    @OneToOne
    private Address address;

    @OneToOne
    private Role role;
}
