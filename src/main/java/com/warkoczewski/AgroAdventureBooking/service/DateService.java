package com.warkoczewski.AgroAdventureBooking.service;

import com.warkoczewski.AgroAdventureBooking.dto.BookingDTO;

import java.util.Date;
import java.util.List;

public interface DateService {
    List<Date> addAll(BookingDTO bookingDTO);
}
