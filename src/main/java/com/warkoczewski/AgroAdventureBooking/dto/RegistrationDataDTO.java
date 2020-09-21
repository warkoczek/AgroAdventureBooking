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

    @NotNull
    private Boolean termsAcceptance;

    public RegistrationDataDTO() {
    }
}
