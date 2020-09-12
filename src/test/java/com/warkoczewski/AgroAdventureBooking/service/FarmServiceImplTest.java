package com.warkoczewski.AgroAdventureBooking.service;

import com.warkoczewski.AgroAdventureBooking.model.Farm;
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
    private  FarmService sut;


    @Test
    void showFarmsByNamePhraseShouldReturnListSize2ForPhraseLand() {
        //given
        String phrase = "land";
        int expectedListSize = 2;
        //when
        List<Farm> farmsByPhrase = sut.showFarmsByNamePhrase(phrase);
        int actualListSize = farmsByPhrase.size();
        //then
        Assert.assertEquals(expectedListSize,actualListSize);
    }
}
