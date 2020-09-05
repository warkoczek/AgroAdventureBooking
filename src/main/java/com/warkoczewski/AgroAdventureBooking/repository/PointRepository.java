package com.warkoczewski.AgroAdventureBooking.repository;

import com.warkoczewski.AgroAdventureBooking.model.Point;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PointRepository {

    List<Point> findAll();
    Optional<Point> findPointByName(String name);
    List<Point> findPointByRegion(String region);
}
