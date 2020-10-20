package com.warkoczewski.AgroAdventureBooking.service.impl;

import com.warkoczewski.AgroAdventureBooking.dto.BookingDTO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class DateServiceImplTest {
    @Autowired
    private DateServiceImpl dateServiceImpl;
    @Test
    @Transactional
    void addAllReturnListSizeOfAddedDatesEqual6() {
        //given
        BookingDTO bookingDTO = new BookingDTO(LocalDate.of(2020,11,01)
                , LocalDate.of(2021,11, 06), "Potato Farm", "dellan");
        int expectedSize = 6;
        //when
        int actualSize = dateServiceImpl.addAll(bookingDTO).size();
        //then
        Assert.assertEquals(expectedSize, actualSize);
    }
}
