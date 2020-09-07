package com.warkoczewski.AgroAdventureBooking.service;

import com.warkoczewski.AgroAdventureBooking.model.Point;

import java.util.List;

public interface PointService {

    public List<Point> showAll();
    public List<Point> showFarmsByRegion(String region);
}
