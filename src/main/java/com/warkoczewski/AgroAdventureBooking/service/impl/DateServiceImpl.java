package com.warkoczewski.AgroAdventureBooking.service.impl;

import com.warkoczewski.AgroAdventureBooking.dto.BookingDTO;
import com.warkoczewski.AgroAdventureBooking.service.DateService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class DateServiceImpl implements DateService {
    @Override
    public List<Date> addAll(BookingDTO bookingDTO) {
        List<com.warkoczewski.AgroAdventureBooking.model.Date> toAdd = new ArrayList<>();
        LocalDate check_in = bookingDTO.getCheck_in();
        LocalDate check_out = bookingDTO.getCheck_out();

        while(!check_in.isAfter(check_out)){
            com.warkoczewski.AgroAdventureBooking.model.Date date = new com.warkoczewski.AgroAdventureBooking.model.Date();
            date.setBooked(true);
            date.setDay(check_in);
            toAdd.add(date);
            check_in = check_in.plusDays(1);

        }
        return null;
    }
}
