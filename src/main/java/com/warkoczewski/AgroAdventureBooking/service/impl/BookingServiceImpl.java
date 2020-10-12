package com.warkoczewski.AgroAdventureBooking.service.impl;

import com.warkoczewski.AgroAdventureBooking.dto.BookingDTO;
import com.warkoczewski.AgroAdventureBooking.exception.BookingDatesOverlappingException;
import com.warkoczewski.AgroAdventureBooking.exception.BookingNotExistsException;
import com.warkoczewski.AgroAdventureBooking.model.Booking;
import com.warkoczewski.AgroAdventureBooking.repository.BookingRepository;
import com.warkoczewski.AgroAdventureBooking.repository.FarmRepository;
import com.warkoczewski.AgroAdventureBooking.repository.UserRepository;
import com.warkoczewski.AgroAdventureBooking.service.BookingService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final FarmRepository farmRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public Booking createFarmBooking(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        if(!datesAreOverlapping(bookingDTO)){
            booking.setCheck_in(bookingDTO.getCheck_in());
            booking.setCheck_out(bookingDTO.getCheck_out());
            booking.setUser(userRepository.getUserByUsername(bookingDTO.getUsername()));
            booking.setFarm(farmRepository.getFarmByName(bookingDTO.getFarmName()));
            bookingRepository.save(booking);
        }else{
            throw new BookingDatesOverlappingException("Booking not possible for the dates you chose");
        }

        return booking;
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.findById(id).ifPresent(bookingRepository::delete);
    }


    private boolean datesAreOverlapping(BookingDTO bookingDTO) {
        return getAllBookings(bookingDTO).values().stream().anyMatch(
                 getBookingOverlappingPredicate(bookingDTO));
    }

    private Predicate<Booking> getBookingOverlappingPredicate(BookingDTO bookingDTO) {
        return booking -> ((bookingDTO.getCheck_in().isAfter(booking.getCheck_in())
                    || bookingDTO.getCheck_in().isEqual(booking.getCheck_in()))
                    && (bookingDTO.getCheck_in().isBefore(booking.getCheck_out())
                    || bookingDTO.getCheck_in().isEqual(booking.getCheck_out())))
                    || ((booking.getCheck_in().isAfter(bookingDTO.getCheck_in())
                    || booking.getCheck_in().isEqual(bookingDTO.getCheck_in()))
                    && (booking.getCheck_in().isBefore(bookingDTO.getCheck_out()))
                    || (booking.getCheck_in().isEqual(bookingDTO.getCheck_out())));
    }

    private Map<Long, Booking> getAllBookings(BookingDTO bookingDTO) {
        return bookingRepository.findAll().stream()
                .filter(getBookingPredicate(bookingDTO))
                .collect(Collectors.toMap(Booking::getBooking_Id, Function.identity()));
    }

    private Predicate<Booking> getBookingPredicate(BookingDTO bookingDTO) {
        return booking -> booking.getFarm().getName().equalsIgnoreCase(bookingDTO.getFarmName());
    }


}
