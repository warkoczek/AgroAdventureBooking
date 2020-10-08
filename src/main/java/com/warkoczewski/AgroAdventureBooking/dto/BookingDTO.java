package com.warkoczewski.AgroAdventureBooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    @DateTimeFormat(pattern = "yyyy-MM--dd")
    private LocalDate check_in;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate check_out;
    private String farmName;
    private String userEmail;
}
