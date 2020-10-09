package com.warkoczewski.AgroAdventureBooking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate check_in;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate check_out;
    @ManyToOne
    private Farm farm;
    @ManyToOne
    private User user;
}
