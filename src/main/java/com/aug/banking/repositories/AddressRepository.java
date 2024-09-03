package com.aug.banking.repositories;

import com.aug.banking.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author AUG-augustin.rakotoarivelo@orange.com
 */
public interface AddressRepository extends JpaRepository<Address,Integer> {
}
