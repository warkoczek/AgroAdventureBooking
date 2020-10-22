package com.warkoczewski.AgroAdventureBooking.service;

import com.warkoczewski.AgroAdventureBooking.dto.BookingDTO;
import com.warkoczewski.AgroAdventureBooking.model.Date;

import java.util.List;

public interface DateService {
    List<Date> addBookedDays(BookingDTO bookingDTO);
}
