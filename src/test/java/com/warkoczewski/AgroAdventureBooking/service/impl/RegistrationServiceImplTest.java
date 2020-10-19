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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class RegistrationServiceImplTest {

    @Autowired
    private RegistrationService registrationService;

    @Test
    @Transactional
    void registerShouldCreateANewUserWithUsernameCzulik() {
        //given
        RegistrationDataDTO registrationDataDTO = new RegistrationDataDTO("mirek","mirek@yahoo.com","Treleokk", "Treleokk");
        String expectedUsername = "mirek";
        //when
        registrationService.register(registrationDataDTO);
        String username = registrationService.findUserByEmail("mirek@yahoo.com").getUsername();
        //then
        Assert.assertEquals(expectedUsername,username);
    }
}
