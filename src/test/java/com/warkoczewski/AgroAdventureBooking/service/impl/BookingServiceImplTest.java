package com.warkoczewski.AgroAdventureBooking.service.impl;

import com.warkoczewski.AgroAdventureBooking.dto.BookingDTO;
import com.warkoczewski.AgroAdventureBooking.model.Booking;
import com.warkoczewski.AgroAdventureBooking.model.Farm;
import com.warkoczewski.AgroAdventureBooking.model.User;
import com.warkoczewski.AgroAdventureBooking.repository.FarmRepository;
import com.warkoczewski.AgroAdventureBooking.repository.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class BookingServiceImplTest {
    @Autowired
    private BookingServiceImpl sut;

    @Test
    void createFarmBookingShouldCreateBookingWithCheckInDate20201101() {
        //given
        BookingDTO bookingDTO = new BookingDTO(LocalDate.of(2021,01,01)
                , LocalDate.of(2021,01, 02), "Chicken House", "mietek");
        LocalDate expectedCheckInDate = LocalDate.of(2021,01,01);
        //when
        Booking farmBooking = sut.createFarmBooking(bookingDTO);
        LocalDate actualCheckInDate = farmBooking.getCheck_in();
        //then
        Assert.assertEquals(expectedCheckInDate,actualCheckInDate);
    }


}
