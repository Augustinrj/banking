package com.aug.banking.service.impl;

import com.aug.banking.config.JwtUtils;
import com.aug.banking.dto.*;
import com.aug.banking.model.Account;
import com.aug.banking.model.Role;
import com.aug.banking.model.User;
import com.aug.banking.repositories.AccountRepository;
import com.aug.banking.repositories.RoleRepository;
import com.aug.banking.repositories.UserRepository;
import com.aug.banking.service.AccountService;
import com.aug.banking.service.UserService;
import com.aug.banking.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author AUG-augustin.rakotoarivelo@orange.com
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private static final String ROLE_USER = "ROLE_USER";
    private final UserRepository repository;
    private final AccountService accountService;
    private final ObjectsValidator<UserDto> validator;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authManager;
    private RoleRepository roleRepository;
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

    @Override
    @Transactional
    public Integer validateAccount(Integer id) {
        User user = repository.findById(id)
                .orElseThrow(()->
                        new EntityNotFoundException("No user was found for user account validation"));
        AccountDto accountDto = AccountDto.builder()
                .user(UserDto.fromEntity(user)).build();
        accountService.save(accountDto);
        user.setActive(true);
        repository.save(user);
        return user.getId();
    }

    @Override
    public Integer invalidateAccount(Integer id) {
        User user = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("No user was found for this account validation"));
        user.setActive(false);
        repository.save(user);
        return user.getId();
    }

    /**
     * @param dto
     * @return
     */
    @Override
    @Transactional
    public AuthenticationResponse register(UserDto dto) {
        validator.validate(dto);
        User user = UserDto.toEntity(dto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(findOrCreate(ROLE_USER));
        User savedUser = repository.save(user);
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId",savedUser.getId());
        claims.put("fullname",savedUser.getFirstname());
        String token = jwtUtils.generateToken(savedUser,claims);
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }

    /**
     * @param request
     * @return
     */
    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        final User user = repository.findByEmail(request.getEmail()).get();
        Map<String,Object> claims = new HashMap<>();
        claims.put("userId",user.getId());
        claims.put("fullName",user.getFirstname()+" "+user.getLastname());
        final String token = jwtUtils.generateToken(user,claims);
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }

    @Override
    public Integer update(LightUserDto userDto) {
        User user = LightUserDto.toEntity(userDto);
        return repository.save(user).getId();
    }

    private Role findOrCreate(String roleName){
        Role role = roleRepository.findByName(roleName)
                .orElse(null);
        if (role == null){
            return roleRepository.save(Role.builder()
                    .name(roleName)
                    .build());
        }
        return role;
    }

}
