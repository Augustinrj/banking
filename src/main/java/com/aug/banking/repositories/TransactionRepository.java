package com.aug.banking.repositories;

import com.aug.banking.dto.TransactionDto;
import com.aug.banking.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author AUG-augustin.rakotoarivelo@orange.com
 */
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

    List<Transaction> findAllByUserId(Integer userId);

    @Query("select sum (t.amount) from Transaction t where t.user.id = :userId")
    BigDecimal findAccountBalance(@Param("userId") Integer userId);
}
