package com.warkoczewski.AgroAdventureBooking.service;

import com.warkoczewski.AgroAdventureBooking.dto.BookingDTO;
import com.warkoczewski.AgroAdventureBooking.model.Booking;

public interface BookingService {
    Booking createFarmBooking(BookingDTO bookingDTO);

}
