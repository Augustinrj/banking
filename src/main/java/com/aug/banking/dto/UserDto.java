package com.aug.banking.dto;

import com.aug.banking.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDto {
    private Integer id;
    @NotNull(message = "Le nom ne peut pas etre vide")
    @NotEmpty(message = "Le nom ne peut pas etre vide")
    @NotBlank(message = "Le nom ne peut pas etre vide")
    private String lastname;

    @NotNull(message = "Le prenom ne peut pas etre vide")
    @NotEmpty(message = "Le prenom ne peut pas etre vide")
    @NotBlank(message = "Le prenom ne peut pas etre vide")
    private String firstname;

    @NotNull(message = "L'email' ne peut pas etre vide")
    @NotEmpty(message = "L'email' ne peut pas etre vide")
    @NotBlank(message = "L'email ne peut pas etre vide")
    @Email(message = "L'email n'est pas comforme")
    private String email;

    @NotNull(message = "Le mot de passe ne peut pas etre vide")
    @NotEmpty(message = "Le mot de passe ne peut pas etre vide")
    @NotBlank(message = "Le mot de passe ne peut pas etre vide")
    @Size(min = 8, max = 16,message = "le mot de doit etre comprise entre 8 et 16 caracteres")
    private String password;

    public static UserDto fromEntity(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public static User toEntity(UserDto user) {
        return User.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
