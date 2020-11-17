package com.warkoczewski.AgroAdventureBooking.controller.farm;

import com.warkoczewski.AgroAdventureBooking.dto.LocationDTO;
import com.warkoczewski.AgroAdventureBooking.service.impl.LocationServiceImpl;
import com.warkoczewski.AgroAdventureBooking.util.Mappings;
import com.warkoczewski.AgroAdventureBooking.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LocationController {

    private final LocationServiceImpl locationServiceImpl;

    public LocationController(LocationServiceImpl locationServiceImpl) {
        this.locationServiceImpl = locationServiceImpl;
    }
/*
    @GetMapping(Mappings.MARKER)
    public String getMap(Model model){
        model.addAttribute("point", new Location(1L, 54.51, 18.53, "Hello Wild Bull"));
        return ViewNames.MAP_TEST_MARKER;
    }*/

    @GetMapping(Mappings.MARKERS)
    public String getAllFarmMarkers(Model model){
        model.addAttribute("points", locationServiceImpl.showAll());
        return ViewNames.MAP;
    }

    @GetMapping(Mappings.CREATE_LOCATION)
        public String getLocationCreationPage(Model model){
            model.addAttribute("locationData", new LocationDTO());
            return "createLocation";
        }
   @PostMapping(Mappings.CREATE_LOCATION)
    public String createLocation(@ModelAttribute("locationDTO") LocationDTO locationData, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "createLocation";
        }
        locationServiceImpl.createLocation(locationData);
        return "createLocation";
    }



}
