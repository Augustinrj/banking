package com.aug.banking.service;

import com.aug.banking.dto.TransactionDto;

import java.util.List;

/**
 * @author AUG-augustin.rakotoarivelo@orange.com
 */
public interface TransactionService extends AbstractService<TransactionDto> {
    List<TransactionDto> findAllByUserId(Integer userId);
}
