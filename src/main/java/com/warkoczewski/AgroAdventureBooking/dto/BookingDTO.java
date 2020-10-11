package com.warkoczewski.AgroAdventureBooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate check_in;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private LocalDate check_out;
    @NotBlank(message = "Fill up this field, please")
    private String farmName;
    @NotBlank(message = "Fill up this field, please")
    private String username;
}
