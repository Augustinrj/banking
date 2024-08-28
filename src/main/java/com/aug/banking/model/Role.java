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
public class Role extends AbstractEntity{

    private String name;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
