package com.warkoczewski.AgroAdventureBooking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long booking_Id;
    @Column(name = "check_in")
    private LocalDate check_in;
    @Column(name = "check_out")
    private LocalDate check_out;
    @ManyToOne
    @JoinColumn(name = "farm_farm_id")
    private Farm farm;
    @ManyToOne
    @JoinColumn(name = "user_username")
    private User user;
}
