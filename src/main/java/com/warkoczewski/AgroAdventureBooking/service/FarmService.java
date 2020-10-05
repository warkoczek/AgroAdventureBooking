package com.warkoczewski.AgroAdventureBooking.service;

import com.warkoczewski.AgroAdventureBooking.dto.FarmDTO;
import com.warkoczewski.AgroAdventureBooking.model.Farm;
import com.warkoczewski.AgroAdventureBooking.repository.FarmRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FarmService {

    private final FarmRepository farmRepository;
    private final ModelMapper modelMapper;

    public FarmService(FarmRepository farmRepository, ModelMapper modelMapper) {
        this.farmRepository = farmRepository;
        this.modelMapper = modelMapper;
    }

    public List<Farm> findAll(){return farmRepository.findAll();}
    public Optional<Farm> showFarmByName(String name) { return farmRepository.findFarmByName(name);
    }


    public List<FarmDTO> showFarmsByNamePhrase(String phrase) {
        return farmRepository.findFarmByNameIsContaining(phrase)
                .stream().map(farm -> modelMapper.map(farm, FarmDTO.class))
                .collect(Collectors.toList());
    }
}
