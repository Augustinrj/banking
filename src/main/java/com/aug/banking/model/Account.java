package com.aug.banking.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Account extends AbstractEntity{

    private String iban;

    private LocalDateTime creationDate;

    private LocalDateTime lastUpdate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
