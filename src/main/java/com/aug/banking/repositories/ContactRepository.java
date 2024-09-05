package com.aug.banking.repositories;

import com.aug.banking.dto.ContactDto;
import com.aug.banking.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author AUG-augustin.rakotoarivelo@orange.com
 */
public interface ContactRepository extends JpaRepository<Contact,Integer> {
    List<Contact> findAllByUserId(Integer userId);
}
