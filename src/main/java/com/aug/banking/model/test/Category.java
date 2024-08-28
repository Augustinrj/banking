package com.aug.banking.model.test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private Integer id;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
