package com.warkoczewski.AgroAdventureBooking.service.impl;

import com.warkoczewski.AgroAdventureBooking.dto.RegistrationDataDTO;
import com.warkoczewski.AgroAdventureBooking.model.User;
import com.warkoczewski.AgroAdventureBooking.repository.UserRepository;
import com.warkoczewski.AgroAdventureBooking.service.RegistrationService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class RegistrationServiceImplTest {

    @Autowired
    private RegistrationService registrationService;

    @Test
    void registerShouldCreateANewUserWithUsernameCzulik() {
        //given
        RegistrationDataDTO registrationDataDTO = new RegistrationDataDTO("czulik","czu@wp.pl","haha", "haha");
        String expectedUsername = "czulik";
        //when
        registrationService.register(registrationDataDTO);
        String username = registrationService.findUserByEmail("czu@wp.pl").getUsername();
        //then
        Assert.assertEquals(expectedUsername,username);
    }
}
