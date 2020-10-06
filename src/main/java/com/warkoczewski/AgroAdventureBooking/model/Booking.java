package com.warkoczewski.AgroAdventureBooking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    private Long id;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date check_in;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date check_out;
    @ManyToOne
    private Farm farm;
    @ManyToOne
    private User user;
}
