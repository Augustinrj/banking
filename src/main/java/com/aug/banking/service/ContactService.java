package com.aug.banking.service;

import com.aug.banking.dto.ContactDto;

import java.util.List;

/**
 * @author AUG-augustin.rakotoarivelo@orange.com
 */
public interface ContactService extends AbstractService<ContactDto> {
    List<ContactDto> findAllByUserId(Integer userId);
}
