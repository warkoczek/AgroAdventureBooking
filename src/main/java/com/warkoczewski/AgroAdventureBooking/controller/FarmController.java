package com.warkoczewski.AgroAdventureBooking.controller;

import com.warkoczewski.AgroAdventureBooking.model.Farm;
import com.warkoczewski.AgroAdventureBooking.service.FarmService;
import com.warkoczewski.AgroAdventureBooking.util.Mappings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class FarmController {

    private final FarmService farmService;

    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    @GetMapping(Mappings.FARM)
    public ModelAndView getFarmByName(@PathVariable("name") String name){
        ModelAndView modelAndView = new ModelAndView("farm");

        Optional<Farm> farm = farmService.showFarmByName(name);
        farm.ifPresent(farm1 -> modelAndView.addObject("farm", farm.get()));
        return modelAndView;
    }
}
