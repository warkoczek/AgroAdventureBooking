package com.warkoczewski.AgroAdventureBooking.service;

import com.warkoczewski.AgroAdventureBooking.model.Farm;

import java.util.Optional;

public interface FarmService {

    Optional<Farm> showFarmByName(String name);
}
