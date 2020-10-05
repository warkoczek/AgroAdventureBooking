package com.warkoczewski.AgroAdventureBooking.service.impl;

import com.warkoczewski.AgroAdventureBooking.dto.FarmDTO;
import com.warkoczewski.AgroAdventureBooking.model.Farm;
import com.warkoczewski.AgroAdventureBooking.service.FarmService;
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
    private FarmService sut;


    @Test
    void showFarmsByNamePhraseShouldReturnListSize2ForPhraseLand() {
        //given
        String phrase = "land";
        int expectedListSize = 2;
        boolean expectedIsAvailable = false;
        //when
        List<FarmDTO> farmsByPhrase = sut.showFarmsByNamePhrase(phrase);
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
        List<FarmDTO> farmsByPhrase = sut.showFarmsByNamePhrase(phrase);
        boolean actualIsAvailable = farmsByPhrase.get(0).isAvailable();
        //then
        Assert.assertEquals(false, actualIsAvailable);
    }
}
