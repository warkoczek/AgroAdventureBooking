package com.warkoczewski.AgroAdventureBooking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    private Long id;
    private LocalDateTime check_in;
    private LocalDateTime check_out;
    @ManyToOne
    private Farm farm;
    @ManyToOne
    private User user;
}
