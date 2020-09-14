package com.warkoczewski.AgroAdventureBooking.controller;

import com.warkoczewski.AgroAdventureBooking.model.Location;
import com.warkoczewski.AgroAdventureBooking.repository.LocationRepository;
import com.warkoczewski.AgroAdventureBooking.util.Mappings;
import com.warkoczewski.AgroAdventureBooking.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class MapController {

    private final LocationRepository locationRepository;

    public MapController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @GetMapping(Mappings.MARKER)
    public String getMap(Model model){
        model.addAttribute("point", new Location(1L, 54.51, 18.53, "Hello Wild Bull"));
        return ViewNames.MAP_TEST_MARKER;
    }

    @GetMapping(Mappings.MARKERS)
    public String getAllFarms(Model model){
        model.addAttribute("points", locationRepository.findAll());
        return ViewNames.MAP;
    }



}
