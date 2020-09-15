package com.warkoczewski.AgroAdventureBooking.service;

import com.warkoczewski.AgroAdventureBooking.model.Location;
import com.warkoczewski.AgroAdventureBooking.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> showAll(){
        return locationRepository.findAll();
    }

    public Long createLocation(Location location){
        return locationRepository.addLocation(location);
    }
}
