package com.warkoczewski.AgroAdventureBooking.repository;

import com.warkoczewski.AgroAdventureBooking.model.Location;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PointRepositoryImpl implements PointRepository {

    private final Set<Location> locations;

    public PointRepositoryImpl() {
        this.locations = new HashSet<>();
        locations.add(new Location(52.78, 17.54, "Agro Warkocz - chickens", "Kujawsko-Pomorskie"));
        locations.add(new Location(49.88, 20.12, "Mustang-Farm - horses", "Malopolskie"));
        locations.add(new Location(54.51, 18.53, "Hello Wild Bull", "Pomorskie"));
    }

    @Override
    public List<Location> findAll() {
        return new ArrayList<>(locations);
    }

    @Override
    public Optional<Location> findPointByName(String name) {
        return locations.stream().filter(point -> point.getName().equalsIgnoreCase(name)).findFirst();
    }

    @Override
    public List<Location> findPointByRegion(String region) {

        return locations.stream()
                .filter(point -> point.getRegion().equalsIgnoreCase(region)).collect(Collectors.toList());
    }
}
