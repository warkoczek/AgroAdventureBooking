package com.warkoczewski.AgroAdventureBooking.service.impl;

import com.warkoczewski.AgroAdventureBooking.dto.BookingDTO;
import com.warkoczewski.AgroAdventureBooking.exception.BookingDatesOverlappingException;
import com.warkoczewski.AgroAdventureBooking.model.Booking;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class BookingServiceImplTest {
    @Autowired
    private BookingServiceImpl sut;

    @Test
    @Transactional
    void createBookingShouldThrowAnExceptionWithMessageForOverlappingCheckInDates() {
        //given
        BookingDTO bookingDTO = new BookingDTO(LocalDate.of(2020,11,01)
                , LocalDate.of(2021,01, 02), "Potato Farm", "dellan");
        LocalDate expectedCheckInDate = LocalDate.of(2020,11,01);
        assertThrows(BookingDatesOverlappingException.class, () -> sut.createBooking(bookingDTO));

    }

    @Test
    @Transactional
    void createBookingShouldCreateBookingWithCheckInDate() {
        //given
        BookingDTO bookingDTO = new BookingDTO(LocalDate.of(2020,11,01)
                , LocalDate.of(2021,01, 02), "Potato Farm", "dellan");
        LocalDate expectedCheckInDate = LocalDate.of(2020,11,01);
        //when
        Booking farmBooking = sut.createBooking(bookingDTO);
        LocalDate actualCheckInDate = farmBooking.getCheck_in();
        //then
        Assert.assertEquals(expectedCheckInDate,actualCheckInDate);
    }

    @Test
    @Transactional
    void deleteBooking() {
        //given
        Long id  = 1l;
        int expectedSize = 0;
        //when
        sut.deleteBooking(id);
        int actualSize = sut.findAll().size();
    }
}
