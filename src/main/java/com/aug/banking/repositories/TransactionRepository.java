package com.aug.banking.repositories;

import com.aug.banking.dto.TransactionDto;
import com.aug.banking.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author AUG-augustin.rakotoarivelo@orange.com
 */
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
