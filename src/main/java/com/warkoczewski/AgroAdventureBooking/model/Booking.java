package com.warkoczewski.AgroAdventureBooking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long booking_Id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate check_in;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate check_out;
    @ManyToOne
    private Farm farm;
    @ManyToOne
    private User user;
}
