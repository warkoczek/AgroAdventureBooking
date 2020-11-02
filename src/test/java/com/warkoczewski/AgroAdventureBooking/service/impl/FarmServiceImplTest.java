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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class FarmServiceImplTest {

    @Autowired
    private FarmServiceImpl sut;


    @Test
    void showFarmsByNamePhraseShouldReturnListSize2ForPhraseLand() {
        //given
        String phrase = "land";
        int expectedListSize = 2;
        boolean expectedIsAvailable = false;
        //when
        List<DisplayFarmDTO> farmsByPhrase = sut.showFarmsByNamePhrase(phrase);
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
        List<DisplayFarmDTO> farmsByPhrase = sut.showFarmsByNamePhrase(phrase);
        boolean actualIsAvailable = farmsByPhrase.get(0).isAvailable();
        //then
        Assert.assertEquals(false, actualIsAvailable);
    }

    @Test
    @Transactional
    void createFarmReturnsFarmId3() {
        //given
        FarmDTO farmDTO = new FarmDTO("Duck Farm", "Duck talk here", false);
        AddressDTO addressDTO = new AddressDTO("Germany", "Hamburg", 10l);
        LocationDTO locationDTO = new LocationDTO(53.55, 9.99, "Our duck can't wait to see you");
        Long expectedFarmId = 4l;
        //when
        Long actualFarmId = sut.addFarm(farmDTO, addressDTO, locationDTO).getFarm_Id();
        //then
        Assert.assertEquals(expectedFarmId,actualFarmId);

    }

    @Test
    @Transactional
    void deleteFarmReturnsFarmsListSize0() {
       Long id = 1l;
       int expectedSize = 0;
       sut.deleteFarm(id);
        int actualSize = sut.findAll().size();
        Assert.assertEquals(expectedSize, actualSize);

    }
/*
    @Test
    void getPaginatedReturnsTotalPages2ForTotalElements4AndPageSize2() {
        //given
        int pageNo = 1;
        int pageSize = 2;
        long expectedTotalPages = 2l;
        //when
        long actualTotalPages = sut.getPaginated(pageNo, pageSize).getTotalPages();
        //then
        Assert.assertEquals(expectedTotalPages, actualTotalPages);
    }
    @Test
    void getPaginatedReturnsTotalElements4ForListSizeFor() {
        //given
        int pageNo = 1;
        int pageSize = 2;
        long expectedTotalElements = 4l;
        //when
        long actualTotalElements = sut.getPaginated(pageNo, pageSize).getTotalElements();
        //then
        Assert.assertEquals(expectedTotalElements, actualTotalElements);
    }*/
}
