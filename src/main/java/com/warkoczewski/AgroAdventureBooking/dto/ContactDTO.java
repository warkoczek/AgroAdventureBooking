package com.warkoczewski.AgroAdventureBooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContactDTO {
    @NotBlank
    private String fullName;
    @NotBlank @Email
    private String emailFrom;
    @NotBlank
    private String subject;
    private String text;
}
