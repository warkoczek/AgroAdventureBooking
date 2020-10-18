package com.warkoczewski.AgroAdventureBooking.dto;

import com.warkoczewski.AgroAdventureBooking.validation.constraints.booking.FarmNameExists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Wrong date. Choose present or future date")
    private LocalDate check_in;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "Wrong date. Choose future date")
    private LocalDate check_out;
    @NotBlank(message = "Fill in this field, please")
    @FarmNameExists(message = "Farm name does not exist")
    private String farmName;
    @NotBlank(message = "Fill in this field, please")
    private String username;
}
