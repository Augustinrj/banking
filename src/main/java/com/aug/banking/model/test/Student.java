package com.aug.banking.model.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne
    private Addresse address;
}
