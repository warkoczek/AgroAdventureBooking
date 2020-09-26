package com.warkoczewski.AgroAdventureBooking.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDataDTO {


    private String username;

    private String email;

    private String password;

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
