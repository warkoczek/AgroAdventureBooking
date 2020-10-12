package com.warkoczewski.AgroAdventureBooking.service;

import com.warkoczewski.AgroAdventureBooking.dto.DisplayFarmDTO;
import com.warkoczewski.AgroAdventureBooking.model.Farm;
import com.warkoczewski.AgroAdventureBooking.repository.FarmRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FarmService {

    private final FarmRepository farmRepository;
    private final ModelMapper modelMapper;

    public FarmService(FarmRepository farmRepository, ModelMapper modelMapper) {
        this.farmRepository = farmRepository;
        this.modelMapper = modelMapper;
    }

    public List<DisplayFarmDTO> findAll(){
        return farmRepository.findAll().stream()
                .map(farm -> modelMapper.map(farm,DisplayFarmDTO.class)).collect(Collectors.toList());
    }

    public DisplayFarmDTO showFarmByName(String name) {
        return modelMapper.map(farmRepository.getFarmByName(name), DisplayFarmDTO.class);
    }


    public List<DisplayFarmDTO> showFarmsByNamePhrase(String phrase) {
        return farmRepository.findFarmByNameIsContaining(phrase)
                .stream().map(farm -> modelMapper.map(farm, DisplayFarmDTO.class))
                .collect(Collectors.toList());
    }
}
