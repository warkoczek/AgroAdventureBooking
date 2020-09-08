package com.warkoczewski.AgroAdventureBooking.service;

import com.warkoczewski.AgroAdventureBooking.model.Farm;
import com.warkoczewski.AgroAdventureBooking.repository.FarmRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;

    public FarmServiceImpl(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    @Override
    public Optional<Farm> showFarmByName(String name) {
        return farmRepository.findFarmByName(name);
    }

    @Override
    public List<Farm> showFarmsByNamePhrase(String phrase) {
        return farmRepository.findFarmByNameIsContaining(phrase);
    }
}
