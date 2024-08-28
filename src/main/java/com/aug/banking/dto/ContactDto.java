package com.aug.banking.dto;


import com.aug.banking.model.Contact;
import com.aug.banking.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ContactDto {
    private Integer id;
    private String firstname;

    private  String lastname;

    private String email;

    private String iban;

    private Integer userId;

    public ContactDto fromEntity(Contact contact){
        return ContactDto.builder()
                .id(contact.getId())
                .firstname(contact.getFirstname())
                .lastname(contact.getLastname())
                .email(contact.getEmail())
                .iban(contact.getIban())
                .userId(
                        contact.getUser().getId()
                )
                .build();
    }
    public ContactDto toEntity(ContactDto contact){
        return ContactDto.builder()
                .id(contact.userId)
                .firstname(contact.getFirstname())
                .lastname(contact.getLastname())
                .email(contact.getEmail())
                .iban(contact.getIban())
                .userId(contact.userId)
                .build();
    }
}
