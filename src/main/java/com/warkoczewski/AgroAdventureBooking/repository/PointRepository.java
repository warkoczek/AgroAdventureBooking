package com.warkoczewski.AgroAdventureBooking.repository;

import com.warkoczewski.AgroAdventureBooking.model.Location;

import java.util.List;
import java.util.Optional;

public interface PointRepository {

    List<Location> findAll();
    Optional<Location> findPointByName(String name);
    List<Location> findPointByRegion(String region);
}
