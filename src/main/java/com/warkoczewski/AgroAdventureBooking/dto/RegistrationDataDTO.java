package com.warkoczewski.AgroAdventureBooking.dto;

import lombok.Data;


import javax.validation.constraints.NotBlank;

@Data
public class RegistrationDataDTO {

    @NotBlank(message = "This field can't be blank")
    private String username;
    @NotBlank(message = "This field can't be blank")
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
