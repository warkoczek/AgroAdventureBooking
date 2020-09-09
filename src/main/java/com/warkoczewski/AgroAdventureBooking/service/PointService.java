package com.warkoczewski.AgroAdventureBooking.service;

import com.warkoczewski.AgroAdventureBooking.model.Point;
import com.warkoczewski.AgroAdventureBooking.repository.PointRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PointService {

    private final PointRepository pointRepository;

    public PointService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    public List<Point> showAll(){
        return pointRepository.findAll();
    }

    public List<Point> showFarmsByRegion(String region){
        return pointRepository.findPointByRegion(region);
    }
}
