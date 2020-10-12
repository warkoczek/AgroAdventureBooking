package com.warkoczewski.AgroAdventureBooking.controller;

import com.warkoczewski.AgroAdventureBooking.dto.BookingDTO;
import com.warkoczewski.AgroAdventureBooking.model.Farm;
import com.warkoczewski.AgroAdventureBooking.service.BookingService;
import com.warkoczewski.AgroAdventureBooking.service.FarmService;
import com.warkoczewski.AgroAdventureBooking.service.impl.BookingServiceImpl;
import com.warkoczewski.AgroAdventureBooking.util.Mappings;
import com.warkoczewski.AgroAdventureBooking.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class BookingController {

    private final BookingServiceImpl bookingServiceImpl;
    private final FarmService farmService;


    public BookingController(BookingServiceImpl bookingServiceImpl, FarmService farmService) {
        this.bookingServiceImpl = bookingServiceImpl;
        this.farmService = farmService;
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
    @GetMapping(Mappings.DELETE_BOOKING)
    public String deleteBooking(@PathVariable("booking_Id") Long id){
        bookingServiceImpl.deleteBooking(id);
        return ViewNames.DELETED;
    }
}
