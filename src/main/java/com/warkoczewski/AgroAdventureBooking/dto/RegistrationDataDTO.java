package com.warkoczewski.AgroAdventureBooking.dto;

import com.warkoczewski.AgroAdventureBooking.validation.constraints.UniqueEmail;
import lombok.Data;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class RegistrationDataDTO {

    @NotBlank(message = "This field can't be blank")
    @Size(min = 4, max = 12, message = "Username characters number must be between 4 and 12")
    private String username;
    @NotBlank(message = "This field can't be blank")
    @Email
    @UniqueEmail
    private String email;
    @NotBlank(message = "This field can't be blank")
    private String password;
    @NotBlank(message = "This field can't be blank")
    private String rePassword;


    public RegistrationDataDTO() {
    }

    public RegistrationDataDTO(String username, String email, String password, String rePassword) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.rePassword = rePassword;
    }
}
