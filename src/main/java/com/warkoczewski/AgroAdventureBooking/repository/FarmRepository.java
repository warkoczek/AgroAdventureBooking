package com.warkoczewski.AgroAdventureBooking.repository;

import com.warkoczewski.AgroAdventureBooking.model.entity.Farm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FarmRepository extends JpaRepository<Farm, Long> {
    List<Farm> findAll();
    Farm getFarmByName(String name);
    List<Farm> findFarmByNameIsContaining(String phrase);
    boolean existsByName(String farmName);
    Page<Farm> findAll(Pageable pageable);
}
