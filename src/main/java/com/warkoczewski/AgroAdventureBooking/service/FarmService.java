package com.warkoczewski.AgroAdventureBooking.service;

import com.warkoczewski.AgroAdventureBooking.dto.AddressDTO;
import com.warkoczewski.AgroAdventureBooking.dto.DisplayFarmDTO;
import com.warkoczewski.AgroAdventureBooking.dto.FarmDTO;
import com.warkoczewski.AgroAdventureBooking.model.Farm;

import java.util.List;
import java.util.Optional;

public interface FarmService {
    Optional<Farm> findFarmById(Long id);
    List<DisplayFarmDTO> findAll();
    DisplayFarmDTO showFarmByName(String name);
    List<DisplayFarmDTO> showFarmsByNamePhrase(String phrase);
    void deleteFarm(Long id);

    Farm addFarm(FarmDTO farmDTO, AddressDTO addressDTO);
}
