package com.aug.banking.service.impl;

import com.aug.banking.dto.AccountDto;
import com.aug.banking.exceptions.OperationNonPermittedException;
import com.aug.banking.model.Account;
import com.aug.banking.repositories.AccountRepository;
import com.aug.banking.service.AccountService;
import com.aug.banking.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author AUG-augustin.rakotoarivelo@orange.com
 */
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;
    private final ObjectsValidator<AccountDto> validator;

    /**
     * @param dto
     * @return
     */
    @Override
    public Integer save(AccountDto dto) {
        validator.validate(dto);
        Account account = AccountDto.toEntity(dto);
        boolean userHasAlreadyAnAccount = repository.findByUserId(account.getId()).isPresent();
        /*if (dto.getId() != null) throw new OperationNonPermittedException(
                    "Account cannot be updated",
                    "save account",
                    "Account",
                    "Update not permitted"
            );*/
        if (userHasAlreadyAnAccount){
            throw new OperationNonPermittedException(
                    "the selected user has already an active account",
                    "Create account",
                    "Account",
                    "Account creation"
            );
        }
        if(dto.getId() == null){
            account.setIban(generatedRandomIban());
        }
        return repository.save(account).getId();
    }

    /**
     * @return
     */
    @Override
    public List<AccountDto> findAll() {
        return repository.findAll().stream()
                .map(AccountDto::fromEntity).collect(Collectors.toList());
    }

    /**
     * @param id
     * @return
     */
    @Override
    public AccountDto findById(Integer id) {
        return repository.findById(id).map(AccountDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No account was found with the ID : "+id));
    }

    /**
     * @param id
     */
    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    private String generatedRandomIban() {
        //todo generate an iban
        String iban = Iban.random(CountryCode.MG).toFormattedString();

        //check if the iban already exists
        boolean ibanExists = repository.findByIban(iban)
                .isPresent();
        //if exists -> generate new random iban
        if (ibanExists) {
            generatedRandomIban();
        }
        //if not exist -> return generated iban

        return iban;
    }
}
