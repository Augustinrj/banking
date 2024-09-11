package com.aug.banking.service.impl;

import com.aug.banking.dto.TransactionDto;
import com.aug.banking.model.Transaction;
import com.aug.banking.model.TransactionType;
import com.aug.banking.repositories.TransactionRepository;
import com.aug.banking.service.TransactionService;
import com.aug.banking.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

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
        validator.validate(dto);
        Transaction transaction = TransactionDto.toEntity(dto);
        BigDecimal transactionMultiplier = BigDecimal.valueOf(getTransactionMultiplier(transaction.getType()));
        BigDecimal amount = transaction.getAmount().multiply(transactionMultiplier);
        transaction.setAmount(amount);
        return repository.save(transaction).getId();
    }

    /**
     * @return
     */
    @Override
    public List<TransactionDto> findAll() {
        return repository.findAll().stream()
                .map(TransactionDto::fromEntity).collect(Collectors.toList());
    }

    /**
     * @param id
     * @return
     */
    @Override
    public TransactionDto findById(Integer id) {
        return repository.findById(id)
                .map(TransactionDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No transaction found with the ID : " + id));
    }

    /**
     * @param id
     */
    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    private int getTransactionMultiplier(TransactionType type){
        return TransactionType.TRANSFERT == type ? -1 : 1;
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public List<TransactionDto> findAllByUserId(Integer userId) {
        return repository.findAllByUserId(userId).stream().map(TransactionDto::fromEntity)
                .collect(Collectors.toList());
    }
}
