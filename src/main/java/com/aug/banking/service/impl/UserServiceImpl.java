package com.aug.banking.service.impl;

import com.aug.banking.dto.UserDto;
import com.aug.banking.model.User;
import com.aug.banking.repositories.UserRepository;
import com.aug.banking.service.UserService;
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
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final ObjectsValidator<UserDto> validator;
    /**
     * @param dto
     * @return Integer
     */
    @Override
    public Integer save(UserDto dto) {
        validator.validate(dto);
        User user = UserDto.toEntity(dto);
        return repository.save(user).getId();
    }

    /**
     * @return List<UserDto>
     */
    @Override
    public List<UserDto> findAll() {
        return repository.findAll().stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    /**
     * @param id
     * @return UserDto
     */
    @Override
    public UserDto findById(Integer id) {
        return repository.findById(id)
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No user found with this provided ID : "+id));
    }

    /**
     * @param id
     */
    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
