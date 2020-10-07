package com.warkoczewski.AgroAdventureBooking.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public class BookingDataDTO {

    private String farmName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate check_in;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate check_out;
    private String username;

}
