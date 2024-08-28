package com.aug.banking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction extends AbstractEntity{
    @Id
    @GeneratedValue
    private Integer id;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private String destinationIban;

    private LocalDateTime creationDate;

    private LocalDateTime lastUpdate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
