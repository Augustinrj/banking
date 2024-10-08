package com.aug.banking.dto;

import lombok.Data;

/**
 * @author AUG-augustin.rakotoarivelo@orange.com
 */
@Data
public class AuthenticationRequest {
    private String email;
    private String password;
}
