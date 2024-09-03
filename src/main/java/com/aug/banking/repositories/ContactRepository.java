package com.aug.banking.repositories;

import com.aug.banking.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author AUG-augustin.rakotoarivelo@orange.com
 */
public interface ContactRepository extends JpaRepository<Contact,Integer> {
}
