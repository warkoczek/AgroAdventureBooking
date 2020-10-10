package com.warkoczewski.AgroAdventureBooking.exception;

public class BookingDatesOverlappingException extends RuntimeException {

    public BookingDatesOverlappingException(String message) {
        super(message);
    }
}
