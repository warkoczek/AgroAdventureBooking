package com.warkoczewski.AgroAdventureBooking.service;

import com.warkoczewski.AgroAdventureBooking.dto.AddressDTO;
import com.warkoczewski.AgroAdventureBooking.dto.DisplayFarmDTO;
import com.warkoczewski.AgroAdventureBooking.dto.FarmDTO;
import com.warkoczewski.AgroAdventureBooking.dto.LocationDTO;
import com.warkoczewski.AgroAdventureBooking.model.entity.Farm;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface FarmService {
    Optional<Farm> findFarmById(Long id);
    List<DisplayFarmDTO> findAll();
    DisplayFarmDTO showFarmByName(String name);
    List<DisplayFarmDTO> showFarmsByNamePhrase(String phrase);
    void deleteFarm(Long id);
    Farm addFarm(FarmDTO farmDTO, AddressDTO addressDTO, LocationDTO locationDTO);
    Page<DisplayFarmDTO> getPaginated(int pageNo, int pageSize);

}
