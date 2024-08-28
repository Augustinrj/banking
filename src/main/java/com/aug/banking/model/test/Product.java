package com.aug.banking.model.test;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Integer id;
    private String code;
    @ManyToOne
    @JoinColumn(name = "id_cat")
    private Category category;
}
