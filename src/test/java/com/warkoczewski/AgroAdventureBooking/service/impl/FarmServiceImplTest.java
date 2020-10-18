package com.warkoczewski.AgroAdventureBooking.service.impl;

import com.warkoczewski.AgroAdventureBooking.dto.AddressDTO;
import com.warkoczewski.AgroAdventureBooking.dto.DisplayFarmDTO;
import com.warkoczewski.AgroAdventureBooking.dto.FarmDTO;
import com.warkoczewski.AgroAdventureBooking.dto.LocationDTO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class FarmServiceImplTest {

    @Autowired
    private FarmServiceImpl farmService;
    @Autowired
    private LocationServiceImpl locationService;
    @Autowired
    private AddressServiceImpl addressService;


    @Test
    void showFarmsByNamePhraseShouldReturnListSize2ForPhraseLand() {
        //given
        String phrase = "land";
        int expectedListSize = 2;
        boolean expectedIsAvailable = false;
        //when
        List<DisplayFarmDTO> farmsByPhrase = farmService.showFarmsByNamePhrase(phrase);
        int actualListSize = farmsByPhrase.size();
        boolean actualIsAvailable = farmsByPhrase.get(1).isAvailable();
        //then
        Assert.assertEquals(expectedListSize,actualListSize);
        Assert.assertEquals(false,actualIsAvailable);
    }
    @Test
    void showFarmsByNamePhraseShouldReturnTrueForIsAvailableForWildFarm(){
        //given
        String phrase = "Wild Farm";
        //when
        List<DisplayFarmDTO> farmsByPhrase = farmService.showFarmsByNamePhrase(phrase);
        boolean actualIsAvailable = farmsByPhrase.get(0).isAvailable();
        //then
        Assert.assertEquals(false, actualIsAvailable);
    }

    @Test
    void createFarmShouldReturnFarmWithId6() {
        //given
        FarmDTO farmDTO = new FarmDTO("We have goats", "Milking goats", "https://images.app.goo.gl/2TwVN261eCbwwjRA6");
        AddressDTO addressDTO = new AddressDTO("Poland", "Zielona2 Góra", "10");
        LocationDTO locationDTO = new LocationDTO(52.8517, 17.3866, "Hello from Goat");
        Long expectedId = 16l;
        //when
        Long actualFarmId = farmService.createFarm(farmDTO, addressDTO).getFarm_Id();
        //then
        Assert.assertEquals(expectedId, actualFarmId);
    }
}
