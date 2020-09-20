package com.warkoczewski.AgroAdventureBooking.service.impl;

import com.warkoczewski.AgroAdventureBooking.dto.LocationDTO;
import com.warkoczewski.AgroAdventureBooking.exception.DuplicateCoordinatesException;
import com.warkoczewski.AgroAdventureBooking.model.Location;
import com.warkoczewski.AgroAdventureBooking.repository.LocationRepository;
import com.warkoczewski.AgroAdventureBooking.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final ModelMapper modelMapper;

    public LocationServiceImpl(LocationRepository locationRepository, ModelMapper modelMapper) {
        this.locationRepository = locationRepository;
        this.modelMapper = modelMapper;
    }

    public List<Location> showAll(){
        return locationRepository.findAll();
    }

    @Override
    public void createLocation(LocationDTO locationData){
        log.debug("Location data to create location: {}", locationData);
        Location location = modelMapper.map(locationData, Location.class);
        log.debug("Location after mapping from locationData: {}", location);
        log.debug("Location before saving: {}", location);
        locationRepository.save(location);
        log.debug("Location after saving: {}", location);

    }
    private void throwDuplicateCoordinatesException(double lat, double lon){
        throw new DuplicateCoordinatesException("Under these coordinates: " + lat + lon + " a business already exists");
    }
}
