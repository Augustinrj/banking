package com.aug.banking.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


@MappedSuperclass
@NoArgsConstructor
@SuperBuilder
public class AbstractEntity {
    @Id
    @GeneratedValue

    private LocalDateTime creationDate;

    private LocalDateTime lastUpdate;
}
