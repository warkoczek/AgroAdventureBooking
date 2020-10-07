package com.warkoczewski.AgroAdventureBooking.repository;

import com.warkoczewski.AgroAdventureBooking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
