package com.warkoczewski.AgroAdventureBooking.service.impl;

import com.warkoczewski.AgroAdventureBooking.dto.AddressDTO;
import com.warkoczewski.AgroAdventureBooking.dto.DisplayFarmDTO;
import com.warkoczewski.AgroAdventureBooking.dto.FarmDTO;
import com.warkoczewski.AgroAdventureBooking.dto.LocationDTO;
import com.warkoczewski.AgroAdventureBooking.model.entity.Address;
import com.warkoczewski.AgroAdventureBooking.model.entity.Farm;
import com.warkoczewski.AgroAdventureBooking.model.entity.Location;
import com.warkoczewski.AgroAdventureBooking.repository.FarmRepository;
import com.warkoczewski.AgroAdventureBooking.service.FarmService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
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
    public Optional<Farm> findFarmById(Long id) {
        return farmRepository.findById(id);
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

    @Override
    public Farm addFarm(FarmDTO farmDTO, AddressDTO addressDTO, LocationDTO locationDTO) {
        Farm farm = modelMapper.map(farmDTO, Farm.class);
        Address address = modelMapper.map(addressDTO, Address.class);
        Location location = modelMapper.map(locationDTO, Location.class);
        farm.setAvailable(farmDTO.isAvailable());
        farm.setAddress(address);
        farm.setLocation(location);
        address.setFarm(farm);
        location.setFarm(farm);
        return farmRepository.save(farm);
    }

    @Override
    public Page<DisplayFarmDTO> getPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return  farmRepository.findAll(pageable).map(farm -> modelMapper.map(farm,DisplayFarmDTO.class));
    }

    public void deleteFarm(Long id) {
        farmRepository.findById(id).ifPresent(farmRepository :: delete);
    }
}
