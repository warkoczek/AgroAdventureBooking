package com.warkoczewski.AgroAdventureBooking.service;

import com.warkoczewski.AgroAdventureBooking.dto.DisplayFarmDTO;
import com.warkoczewski.AgroAdventureBooking.dto.FarmDTO;
import com.warkoczewski.AgroAdventureBooking.model.Farm;

import java.util.List;

public interface FarmService {
    List<DisplayFarmDTO> findAll();
    DisplayFarmDTO showFarmByName(String name);
    List<DisplayFarmDTO> showFarmsByNamePhrase(String phrase);
    void deleteFarm(Long id);
    Farm createFarm(FarmDTO farmDTO);
}
