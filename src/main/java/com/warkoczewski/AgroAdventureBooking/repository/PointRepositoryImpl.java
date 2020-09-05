package com.warkoczewski.AgroAdventureBooking.repository;

import com.warkoczewski.AgroAdventureBooking.model.Point;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PointRepositoryImpl implements PointRepository {

    private final Set<Point> locations;

    public PointRepositoryImpl() {
        this.locations = new HashSet<>();
        locations.add(new Point(52.78, 17.54, "Agro Warkocz - chickens", "Kujawsko-Pomorskie"));
        locations.add(new Point(49.88, 20.12, "Mustang-Farm - horses", "Malopolskie"));
        locations.add(new Point(54.51, 18.53, "Hello Wild Bull", "Pomorskie"));
    }

    @Override
    public List<Point> findAll() {
        return new ArrayList<>(locations);
    }

    @Override
    public Optional<Point> findPointByName(String name) {
        return locations.stream().filter(point -> point.getName().equalsIgnoreCase(name)).findFirst();
    }

    @Override
    public List<Point> findPointByRegion(String region) {

        return locations.stream()
                .filter(point -> point.getRegion().equalsIgnoreCase(region)).collect(Collectors.toList());
    }
}
