package com.warkoczewski.AgroAdventureBooking;

import com.warkoczewski.AgroAdventureBooking.repository.AddressRepository;
import com.warkoczewski.AgroAdventureBooking.repository.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgroAdventureBookingApplication {


	public static void main(String[] args) {
		SpringApplication.run(AgroAdventureBookingApplication.class, args);
	}


}
