package com.aug.banking.service;

import com.aug.banking.dto.AuthenticationRequest;
import com.aug.banking.dto.AuthenticationResponse;
import com.aug.banking.dto.LightUserDto;
import com.aug.banking.dto.UserDto;

/**
 * @author AUG-augustin.rakotoarivelo@orange.com
 */
public interface UserService extends AbstractService<UserDto> {
    Integer validateAccount(Integer id);
    Integer invalidateAccount(Integer id);
    AuthenticationResponse register(UserDto user);
    AuthenticationResponse authenticate(AuthenticationRequest request);
    Integer update (LightUserDto userDto);
}
