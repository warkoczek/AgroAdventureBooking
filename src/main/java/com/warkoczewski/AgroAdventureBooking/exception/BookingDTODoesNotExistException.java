package com.warkoczewski.AgroAdventureBooking.exception;

public class BookingDTODoesNotExistException extends RuntimeException {

    public BookingDTODoesNotExistException(String message) {
        super(message);
    }
}
