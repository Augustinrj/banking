package com.aug.banking.service.impl;

import com.aug.banking.dto.AddressDto;
import com.aug.banking.model.Address;
import com.aug.banking.repositories.AddressRepository;
import com.aug.banking.service.AddressService;
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
public class AddressServiceImpl implements AddressService {
    private final AddressRepository repository;
    private final ObjectsValidator<AddressDto> validator;
    /**
     * @param dto
     * @return
     */
    @Override
    public Integer save(AddressDto dto) {
        validator.validate(dto);
        Address address = AddressDto.toEntity(dto);
        return repository.save(address).getId();
    }

    /**
     * @return
     */
    @Override
    public List<AddressDto> findAll() {
        return repository.findAll().stream()
                .map(AddressDto::fromEntity).collect(Collectors.toList());
    }

    /**
     * @param id
     * @return
     */
    @Override
    public AddressDto findById(Integer id) {
        return repository.findById(id)
                .map(AddressDto::fromEntity).orElseThrow(() -> new EntityNotFoundException("No address found with the ID : "+id));
    }

    /**
     * @param id
     */
    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
