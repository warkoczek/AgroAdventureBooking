package com.warkoczewski.AgroAdventureBooking.repository;

import com.warkoczewski.AgroAdventureBooking.model.Location;

import java.util.List;
import java.util.Optional;

public interface LocationRepository {

    List<Location> findAll();
    Optional<Location> findPointByName(String name);

}
