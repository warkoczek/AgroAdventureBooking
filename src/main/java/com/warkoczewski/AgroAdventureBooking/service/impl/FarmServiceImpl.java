package com.warkoczewski.AgroAdventureBooking.service.impl;

import com.warkoczewski.AgroAdventureBooking.dto.DisplayFarmDTO;
import com.warkoczewski.AgroAdventureBooking.dto.FarmDTO;
import com.warkoczewski.AgroAdventureBooking.model.Farm;
import com.warkoczewski.AgroAdventureBooking.repository.FarmRepository;
import com.warkoczewski.AgroAdventureBooking.service.FarmService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;
    private final ModelMapper modelMapper;

    public FarmServiceImpl(FarmRepository farmRepository, ModelMapper modelMapper) {
        this.farmRepository = farmRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<DisplayFarmDTO> findAll(){
        return farmRepository.findAll().stream()
                .map(farm -> modelMapper.map(farm,DisplayFarmDTO.class)).collect(Collectors.toList());
    }
    @Override
    public DisplayFarmDTO showFarmByName(String name) {
        return modelMapper.map(farmRepository.getFarmByName(name), DisplayFarmDTO.class);
    }

    @Override
    public List<DisplayFarmDTO> showFarmsByNamePhrase(String phrase) {
        return farmRepository.findFarmByNameIsContaining(phrase)
                .stream().map(farm -> modelMapper.map(farm, DisplayFarmDTO.class))
                .collect(Collectors.toList());
    }
    @Override
    public void deleteFarm(Long id) {
        farmRepository.findById(id).ifPresent(farmRepository :: delete);
    }
    @Override
    public Farm createFarm(FarmDTO farmDTO) {
        return null;
    }
}
