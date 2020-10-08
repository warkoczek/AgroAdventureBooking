package com.warkoczewski.AgroAdventureBooking.service.impl;

import com.warkoczewski.AgroAdventureBooking.dto.BookingDTO;
import com.warkoczewski.AgroAdventureBooking.model.Booking;
import com.warkoczewski.AgroAdventureBooking.model.Farm;
import com.warkoczewski.AgroAdventureBooking.model.User;
import com.warkoczewski.AgroAdventureBooking.repository.BookingRepository;
import com.warkoczewski.AgroAdventureBooking.repository.FarmRepository;
import com.warkoczewski.AgroAdventureBooking.repository.UserRepository;
import com.warkoczewski.AgroAdventureBooking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final FarmRepository farmRepository;
    private final ModelMapper modelMapper;

    @Override
    public void bookFarm(BookingDTO bookingDTO) {
        User user = userRepository.getUserByEmail(bookingDTO.getUserEmail());
        Farm farm = farmRepository.getFarmByName(bookingDTO.getFarmName());
        Booking booking = new Booking();
        if(datesNotOverlapping()){
            booking.setCheck_in(bookingDTO.getCheck_in());
            booking.setCheck_out(bookingDTO.getCheck_out());
        }
        booking.setUser(userRepository.getUserByEmail(bookingDTO.getUserEmail()));
        booking.setFarm(farmRepository.getFarmByName(bookingDTO.getFarmName()));
        bookingRepository.save(booking);
    }


    private boolean datesNotOverlapping() {
        Map<Long, Booking> bookingMap = getAllBookings();

        return false;
    }

    private Map<Long, Booking> getAllBookings() {
        return bookingRepository.findAll().stream()
                .collect(Collectors.toMap(Booking::getId, Function.identity()));
    }


}
