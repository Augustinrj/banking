package com.aug.banking.dto;
import com.aug.banking.model.Account;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class AccountDto {
    private Integer id;

    private String iban;

    private UserDto user;

    public static  AccountDto fromEntity(Account account){
        return AccountDto.builder()
                .user(UserDto.fromEntity(account.getUser()))
                .iban(account.getIban())
                .build();
    }

    public static Account toEntity (AccountDto account){
        return Account.builder()
                .user(UserDto.toEntity(account.getUser()))
                .iban(account.getIban())
                .build();
    }
}
