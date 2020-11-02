package com.warkoczewski.AgroAdventureBooking.service;

import com.warkoczewski.AgroAdventureBooking.dto.BookingDTO;
import com.warkoczewski.AgroAdventureBooking.model.entity.Booking;

public interface BookingService {
    Booking createBooking(BookingDTO bookingDTO);

    void deleteBooking(Long id);
}
