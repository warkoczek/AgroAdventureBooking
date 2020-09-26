package com.warkoczewski.AgroAdventureBooking.service;

import com.warkoczewski.AgroAdventureBooking.dto.RegistrationDataDTO;
import com.warkoczewski.AgroAdventureBooking.model.User;
import java.util.Optional;

public interface RegistrationService {

    Optional<User> findUserByEmail(String email);
    void register( RegistrationDataDTO registrationData);
}
