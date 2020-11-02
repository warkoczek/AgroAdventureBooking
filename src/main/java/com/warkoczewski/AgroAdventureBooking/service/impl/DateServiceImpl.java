package com.warkoczewski.AgroAdventureBooking.service.impl;
import com.warkoczewski.AgroAdventureBooking.dto.BookingDTO;
import com.warkoczewski.AgroAdventureBooking.model.entity.Date;
import com.warkoczewski.AgroAdventureBooking.repository.DateRepository;
import com.warkoczewski.AgroAdventureBooking.service.DateService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class DateServiceImpl implements DateService {
    private final DateRepository dateRepository;

    public DateServiceImpl(DateRepository dateRepository) {
        this.dateRepository = dateRepository;
    }

    @Override
    public List<Date> addBookedDays(BookingDTO bookingDTO) {
        List<Date> toAdd = new ArrayList<>();
        LocalDate check_in = bookingDTO.getCheck_in();
        LocalDate check_out = bookingDTO.getCheck_out();

        while(!check_in.isAfter(check_out)){
            Date date = new Date();
            date.setBooked(true);
            date.setDay(check_in);
            toAdd.add(date);
            check_in = check_in.plusDays(1);
        }

        return dateRepository.saveAll(toAdd);
    }
}
