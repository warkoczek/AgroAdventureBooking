package com.warkoczewski.AgroAdventureBooking.controller.booking;

import com.warkoczewski.AgroAdventureBooking.dto.BookingDTO;
import com.warkoczewski.AgroAdventureBooking.dto.DisplayFarmDTO;
import com.warkoczewski.AgroAdventureBooking.service.impl.FarmServiceImpl;
import com.warkoczewski.AgroAdventureBooking.service.impl.BookingServiceImpl;
import com.warkoczewski.AgroAdventureBooking.util.Mappings;
import com.warkoczewski.AgroAdventureBooking.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class BookingController {

    private final BookingServiceImpl bookingServiceImpl;
    private final FarmServiceImpl farmService;


    public BookingController(BookingServiceImpl bookingServiceImpl, FarmServiceImpl farmService) {
        this.bookingServiceImpl = bookingServiceImpl;
        this.farmService = farmService;
    }
    @GetMapping(Mappings.FARM_BOOKED)
    public String getFarmBookedPage(){
        return ViewNames.FARM_BOOKED;
    }
    @GetMapping(Mappings.BOOKING_NOT_POSSIBLE)
    public String getBookingNotPossiblePage(){
        return ViewNames.BOOKING_NOT_POSSIBLE;
    }


    @GetMapping(Mappings.BOOKING_PAGE_FARM_NAME)
    public String getBookingPage(@PathVariable(value = "name") String name, Model model){
        DisplayFarmDTO displayFarmDTO = farmService.showFarmByName(name);
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setFarmName(displayFarmDTO.getName());
        model.addAttribute("bookingDTO", bookingDTO);
        return ViewNames.BOOKING_PAGE;
    }

    @PostMapping(Mappings.BOOKING_PAGE)
    public String bookFarm(@Valid @ModelAttribute("bookingDTO") BookingDTO bookingDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ViewNames.BOOKING_PAGE;
        }
        bookingServiceImpl.createBooking(bookingDTO);
        return ViewNames.FARM_BOOKED;
    }
    @GetMapping(Mappings.DELETE_BOOKING)
    public String deleteBooking(@PathVariable("booking_Id") Long id){
        bookingServiceImpl.deleteBooking(id);
        return ViewNames.BOOKING_DELETED;
    }
}
