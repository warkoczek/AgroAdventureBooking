package com.warkoczewski.AgroAdventureBooking.service.impl;

import com.warkoczewski.AgroAdventureBooking.dto.AddressDTO;
import com.warkoczewski.AgroAdventureBooking.dto.DisplayFarmDTO;
import com.warkoczewski.AgroAdventureBooking.dto.FarmDTO;
import com.warkoczewski.AgroAdventureBooking.dto.LocationDTO;
import com.warkoczewski.AgroAdventureBooking.model.Farm;
import com.warkoczewski.AgroAdventureBooking.repository.FarmRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.AssertTrue;
import java.util.List;
import java.util.Optional;

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
    void createFarmReturnsFarmId2() {
        //given
        FarmDTO farmDTO = new FarmDTO("Potato Farm", "Potato as big as your head");
        AddressDTO addressDTO = new AddressDTO("Poland", "Żerniki", 17l);
        LocationDTO locationDTO = new LocationDTO(52.47, 17.33, "Hi from head-size potato");
        Long expectedFarmId = 2l;
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
}
