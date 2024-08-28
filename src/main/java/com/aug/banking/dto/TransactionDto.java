package com.aug.banking.dto;


import com.aug.banking.model.Transaction;
import com.aug.banking.model.TransactionType;
import com.aug.banking.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TransactionDto {

    private Integer id;

    @Positive
    @Max(value = 100_000_000)
    @Min(value = 100)
    private BigDecimal amount;

    private TransactionType transactionType;

    private String destinationIban;

    private LocalDateTime creationDate;

    private LocalDateTime lastUpdate;

    private Integer userId;

    public TransactionDto fromEntity(Transaction transaction){
        return TransactionDto.builder()
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .transactionType(transaction.getTransactionType())
                .destinationIban(transaction.getDestinationIban())
                .creationDate(transaction.getCreationDate())
                .lastUpdate(transaction.getLastUpdate())
                .userId(transaction.getUser().getId())
                .build();
    }
    public Transaction toEntity(TransactionDto transaction){
        return Transaction.builder()
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .transactionType(transaction.getTransactionType())
                .destinationIban(transaction.getDestinationIban())
                .creationDate(transaction.getCreationDate())
                .lastUpdate(transaction.getLastUpdate())
                .user(
                        User.builder()
                                .id(transaction.userId)
                                .build()
                )
                .build();
    }
}
