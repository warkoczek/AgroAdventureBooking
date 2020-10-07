package com.warkoczewski.AgroAdventureBooking.controller;

import com.warkoczewski.AgroAdventureBooking.service.BookingService;
import com.warkoczewski.AgroAdventureBooking.service.impl.BookingServiceImpl;
import com.warkoczewski.AgroAdventureBooking.util.Mappings;
import com.warkoczewski.AgroAdventureBooking.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingController {

    private final BookingServiceImpl bookingServiceImpl;

    public BookingController(BookingServiceImpl bookingServiceImpl) {
        this.bookingServiceImpl=bookingServiceImpl;
    }

    @GetMapping(Mappings.BOOKING_PAGE)
    public String getBookingPage(){
        return ViewNames.BOOKING_PAGE;
    }
}
