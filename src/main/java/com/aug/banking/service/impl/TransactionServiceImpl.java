package com.aug.banking.service.impl;

import com.aug.banking.dto.TransactionDto;
import com.aug.banking.repositories.TransactionRepository;
import com.aug.banking.service.TransactionService;
import com.aug.banking.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author AUG-augustin.rakotoarivelo@orange.com
 */
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;
    private final ObjectsValidator<TransactionDto> validator;

    /**
     * @param dto
     * @return
     */
    @Override
    public Integer save(TransactionDto dto) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<TransactionDto> findAll() {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public TransactionDto findById(Integer id) {
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void delete(Integer id) {

    }
}
