package com.warkoczewski.AgroAdventureBooking.controller;

import com.warkoczewski.AgroAdventureBooking.model.Farm;
import com.warkoczewski.AgroAdventureBooking.service.FarmService;
import com.warkoczewski.AgroAdventureBooking.util.Mappings;
import com.warkoczewski.AgroAdventureBooking.util.ViewNames;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class FarmController {

    private final FarmService farmService;

    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    @GetMapping(Mappings.HOME)
    public String getHomePage(){
        return ViewNames.HOME;
    }
    @GetMapping(Mappings.ALL_FARMS)
    public ModelAndView showAllFarms(ModelAndView modelAndView){
        List<Farm> allFarms = farmService.findAll();
        modelAndView.setViewName("farm/allFarms");
        modelAndView.addObject("allFarms", allFarms);
        return modelAndView;
    }

    @GetMapping(value = Mappings.SEARCH_FARMS)
    public ModelAndView searchFarmByNamePhrase(@RequestParam(defaultValue = "*") String phrase){

        ModelAndView modelAndView = new ModelAndView("searchFarms");

        List<Farm> farmsByPhrase = farmService.showFarmsByNamePhrase(phrase);
        modelAndView.addObject("farms", farmsByPhrase);

        return modelAndView;
    }
    @GetMapping(Mappings.FARM)
    public ModelAndView getFarmByName(@PathVariable("name") String name){

        ModelAndView modelAndView = new ModelAndView("/main/resources/templates/farm/farm.html");

        Optional<Farm> farm = farmService.showFarmByName(name);
        farm.ifPresent(farm1 -> modelAndView.addObject("farm", farm.get()));
        return modelAndView;
    }
}
