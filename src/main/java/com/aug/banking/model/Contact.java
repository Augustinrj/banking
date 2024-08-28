package com.aug.banking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
public class Contact extends AbstractEntity{
    private Integer id;
    private String firstname;
    private  String lastname;
    private String email;
    private String iban;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
