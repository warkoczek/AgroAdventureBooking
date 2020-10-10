package com.warkoczewski.AgroAdventureBooking.service;

import com.warkoczewski.AgroAdventureBooking.dto.RegistrationDataDTO;
import com.warkoczewski.AgroAdventureBooking.model.User;


public interface RegistrationService {

    User findUserByEmail(String email);
    void register( RegistrationDataDTO registrationData);
}
