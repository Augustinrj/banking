package com.aug.banking.service.impl;

import com.aug.banking.dto.ContactDto;
import com.aug.banking.model.Contact;
import com.aug.banking.repositories.ContactRepository;
import com.aug.banking.service.ContactService;
import com.aug.banking.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author AUG-augustin.rakotoarivelo@orange.com
 */
@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository repository;
    private final ObjectsValidator<ContactDto> validator;

    /**
     * @param dto
     * @return
     */
    @Override
    public Integer save(ContactDto dto) {
        validator.validate(dto);
        Contact contact = ContactDto.toEntity(dto);
        return repository.save(contact).getId();
    }

    /**
     * @return
     */
    @Override
    public List<ContactDto> findAll() {
        return repository.findAll().stream()
                .map(ContactDto::fromEntity)
                .collect(Collectors.toList());
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ContactDto findById(Integer id) {
        return repository.findById(id)
                .map(ContactDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("No Contact found with the ID "+id));
    }

    /**
     * @param id
     */
    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public List<ContactDto> findAllByUserId(Integer userId) {
        return repository.findAllByUserId(userId).stream()
                .map(ContactDto::fromEntity).collect(Collectors.toList());
    }
}
