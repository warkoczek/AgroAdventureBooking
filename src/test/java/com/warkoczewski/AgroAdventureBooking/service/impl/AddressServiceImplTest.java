package com.warkoczewski.AgroAdventureBooking.service.impl;

import com.warkoczewski.AgroAdventureBooking.dto.AddressDTO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class AddressServiceImplTest {
    @Autowired
    private AddressServiceImpl sut;

    @Test
    void createAddressShouldReturnAddressWithId5() {
        //given
        AddressDTO addressDTO = new AddressDTO("Poland", "Kołybki", "10");
        Long expectedAddressId = 6l;
        //when
        Long actualAddressId = sut.createAddress(addressDTO).getAddress_Id();
        //then
        Assert.assertEquals(expectedAddressId,actualAddressId);
    }
}
