package com.warkoczewski.AgroAdventureBooking.controller;

import com.warkoczewski.AgroAdventureBooking.model.Location;
import com.warkoczewski.AgroAdventureBooking.repository.LocationRepository;
import com.warkoczewski.AgroAdventureBooking.service.LocationService;
import com.warkoczewski.AgroAdventureBooking.util.Mappings;
import com.warkoczewski.AgroAdventureBooking.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping(Mappings.MARKER)
    public String getMap(Model model){
        model.addAttribute("point", new Location(1L, 54.51, 18.53, "Hello Wild Bull"));
        return ViewNames.MAP_TEST_MARKER;
    }

    @GetMapping(Mappings.MARKERS)
    public String getAllFarms(Model model){
        model.addAttribute("points", locationService.showAll());
        return ViewNames.MAP;
    }

    @GetMapping(Mappings.CREATE_LOCATION)
        public String getPage(){
            return "createLocation";
        }
   /* @PostMapping("/createLocation")
    public ModelAndView createLocation(@ModelAttribute("location") Location location, ModelAndView modelAndView){
        modelAndView.setViewName("locationCreated");
        Long locationId = locationService.createLocation(location);
        modelAndView.addObject("message", "Location created successfully with this id: " + locationId);
        return modelAndView;
    }*/



}
