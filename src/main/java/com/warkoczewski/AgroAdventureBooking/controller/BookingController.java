package com.warkoczewski.AgroAdventureBooking.controller;

import com.warkoczewski.AgroAdventureBooking.dto.BookingDTO;
import com.warkoczewski.AgroAdventureBooking.service.BookingService;
import com.warkoczewski.AgroAdventureBooking.service.impl.BookingServiceImpl;
import com.warkoczewski.AgroAdventureBooking.util.Mappings;
import com.warkoczewski.AgroAdventureBooking.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class BookingController {

    private final BookingServiceImpl bookingServiceImpl;

    public BookingController(BookingServiceImpl bookingServiceImpl) {
        this.bookingServiceImpl=bookingServiceImpl;
    }

    @GetMapping(Mappings.BOOKING_PAGE)
    public String getBookingPage(Model model){
        model.addAttribute("bookingDTO", new BookingDTO());
        return ViewNames.BOOKING_PAGE;
    }

    @PostMapping(Mappings.BOOKING_PAGE)
    public String bookFarm(@Valid @ModelAttribute("bookingDTO") BookingDTO bookingDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ViewNames.BOOKING_PAGE;
        }
        bookingServiceImpl.createFarmBooking(bookingDTO);
        return ViewNames.FARM_BOOKED;
    }
}
