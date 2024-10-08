package com.aug.banking.controllers;

import com.aug.banking.dto.AuthenticationRequest;
import com.aug.banking.dto.AuthenticationResponse;
import com.aug.banking.dto.UserDto;
import com.aug.banking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AUG-augustin.rakotoarivelo@orange.com
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController  {
    private final UserService userService;
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserDto user){
        return ResponseEntity.ok(userService.register(user));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(userService.authenticate(request));
    }
}
