package com.warkoczewski.AgroAdventureBooking.service;

import com.warkoczewski.AgroAdventureBooking.exception.DuplicateCoordinatesException;
import com.warkoczewski.AgroAdventureBooking.model.Location;
import com.warkoczewski.AgroAdventureBooking.repository.LocationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LocationService {

    private final LocationRepository locationRepository;
    private final ModelMapper modelMapper;

    public LocationService(LocationRepository locationRepository, ModelMapper modelMapper) {
        this.locationRepository = locationRepository;
        this.modelMapper = modelMapper;
    }

    public List<Location> showAll(){
        return locationRepository.findAll();
    }

    public Long createLocation(Location location){
        locationRepository.findPointByLatAndLon(location.getLat(), location.getLon())
                .ifPresent(location1 -> throwDuplicateCoordinatesException(location.getLat(), location.getLon()));
        Location locationToSave = locationRepository.save(location);
        return locationToSave.getLoc_Id();
    }
    private void throwDuplicateCoordinatesException(double lat, double lon){
        throw new DuplicateCoordinatesException("Under these coordinates: " + lat + lon + " a business already exists");
    }
}
