package com.warkoczewski.AgroAdventureBooking.repository;

import com.warkoczewski.AgroAdventureBooking.model.Date;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface DateRepository extends JpaRepository<Date, LocalDate> {

}
