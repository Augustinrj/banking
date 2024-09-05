package com.aug.banking.service.impl;

import com.aug.banking.model.TransactionType;
import com.aug.banking.repositories.TransactionRepository;
import com.aug.banking.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

/**
 * @author AUG-augustin.rakotoarivelo@orange.com
 */
@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {

    private final TransactionRepository transactionRepository;
    /**
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public Map<LocalDate, BigDecimal> findSumTransactionsByDate(LocalDate startDate, LocalDate endDate,Integer userId) {
        LocalDateTime start = LocalDateTime.of(startDate, LocalTime.of(0,0,0));
        LocalDateTime end = LocalDateTime.of(endDate,LocalTime.of(23,59,59));
        return transactionRepository.findSumTransactionByDate(start,end,userId);
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public BigDecimal getAccountBalance(Integer userId) {
        return transactionRepository.findAccountBalance(userId);
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public BigDecimal highestTransfert(Integer userId) {
        return transactionRepository.findHighestAmountByTransactionType(userId, TransactionType.TRANSFERT);
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public BigDecimal highestDeposit(Integer userId) {
        return null;
    }
}
