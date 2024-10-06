package com.aug.banking.service;

import com.aug.banking.dto.TransactionSumDetails;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author AUG-augustin.rakotoarivelo@orange.com
 */
public interface StatisticsService {
    List<TransactionSumDetails> findSumTransactionsByDate(LocalDate startDate, LocalDate endDate, Integer userId);
    BigDecimal getAccountBalance(Integer userId);
    BigDecimal highestTransfert(Integer userId);
    BigDecimal highestDeposit(Integer userId);
}
