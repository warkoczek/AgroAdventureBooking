package com.warkoczewski.AgroAdventureBooking.exception;

public class FarmNotFoundException extends RuntimeException {

    public FarmNotFoundException() {
        super("Not found");
    }
}
