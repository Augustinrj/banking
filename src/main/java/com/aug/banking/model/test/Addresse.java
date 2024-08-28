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
public class Addresse {
    @Id
    @GeneratedValue
    Integer id;
    String street;
    @OneToOne
    @JoinColumn(name = "id_student")
    private Student student;
}
