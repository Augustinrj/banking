package com.aug.banking.repositories;

import com.aug.banking.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author AUG-augustin.rakotoarivelo@orange.com
 */
public interface AccountRepository extends JpaRepository <Account,Integer> {
     Optional<Account> findByIban(String iban);
}
