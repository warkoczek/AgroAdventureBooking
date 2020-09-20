package com.warkoczewski.AgroAdventureBooking.service.impl;

import com.warkoczewski.AgroAdventureBooking.dto.RegistrationDataDTO;
import com.warkoczewski.AgroAdventureBooking.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Slf4j
@Validated
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
    @Override
    public void register(RegistrationDataDTO registrationData) {

    }
}
