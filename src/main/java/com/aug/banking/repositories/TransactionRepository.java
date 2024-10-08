package com.aug.banking.repositories;

import com.aug.banking.dto.TransactionDto;
import com.aug.banking.dto.TransactionSumDetails;
import com.aug.banking.model.Transaction;
import com.aug.banking.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author AUG-augustin.rakotoarivelo@orange.com
 */
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

    List<Transaction> findAllByUserId(Integer userId);

    @Query("select sum (t.amount) from Transaction t where t.user.id = :userId")
    BigDecimal findAccountBalance(@Param("userId") Integer userId);

    @Query("select t.transactionDate as transactionDate, sum(t.amount) as amount from Transaction t where t.user.id = :userId and t.createdDate between :start and :end group by t.transactionDate")
    List<TransactionSumDetails> findSumTransactionByDate(LocalDateTime start, LocalDateTime end, Integer userId);

    @Query("select max (abs(t.amount)) as amount from Transaction t where t.user.id = :userId and t.type = :type")
    BigDecimal findHighestAmountByTransactionType(Integer userId, TransactionType type);
}
