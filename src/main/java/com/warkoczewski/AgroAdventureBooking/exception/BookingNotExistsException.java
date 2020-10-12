package com.warkoczewski.AgroAdventureBooking.exception;

public class BookingNotExistsException extends RuntimeException {
    public BookingNotExistsException(String message) {
        super(message);
    }
}
