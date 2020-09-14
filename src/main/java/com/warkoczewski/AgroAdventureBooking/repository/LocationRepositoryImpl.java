package com.warkoczewski.AgroAdventureBooking.repository;

import com.warkoczewski.AgroAdventureBooking.model.Location;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class LocationRepositoryImpl implements LocationRepository {

    private final Set<Location> locations;

    public LocationRepositoryImpl() {
        this.locations = new HashSet<>();
        locations.add(new Location(1L, 52.78, 17.54, "Agro Warkocz - chickens"));
        locations.add(new Location(2L, 49.88, 20.12, "Mustang-Farm - horses"));
        locations.add(new Location(3L, 54.51, 18.53, "Hello Wild Bull"));
    }

    @Override
    public List<Location> findAll() {
        return new ArrayList<>(locations);
    }

    @Override
    public Optional<Location> findPointByName(String name) {
        return locations.stream().filter(point -> point.getName().equalsIgnoreCase(name)).findFirst();
    }


}
