package com.aug.banking.service.impl;

import com.aug.banking.repositories.TransactionRepository;
import com.aug.banking.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
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
    public Map<LocalDate, BigDecimal> findSumTransactionsByDate(LocalDate startDate, LocalDate endDate) {
        return null;
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
        return null;
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
