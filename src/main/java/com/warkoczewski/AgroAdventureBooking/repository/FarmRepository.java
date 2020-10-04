package com.warkoczewski.AgroAdventureBooking.repository;

import com.warkoczewski.AgroAdventureBooking.model.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface FarmRepository extends JpaRepository<Farm, Long> {
    List<Farm> findAll();
    Optional<Farm> findFarmByName(String name);
    List<Farm> findFarmByNameIsContaining(String phrase);

}
