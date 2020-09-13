package com.warkoczewski.AgroAdventureBooking.controller;

import com.warkoczewski.AgroAdventureBooking.model.Farm;
import com.warkoczewski.AgroAdventureBooking.service.FarmService;
import com.warkoczewski.AgroAdventureBooking.util.Mappings;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
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


    @GetMapping(value = Mappings.SEARCH_FARMS)
    public ModelAndView searchFarmByNamePhrase(@RequestParam(defaultValue = "*") String phrase){

        ModelAndView modelAndView = new ModelAndView("searchFarms");

        List<Farm> farmsByPhrase = farmService.showFarmsByNamePhrase(phrase);
        modelAndView.addObject("farms", farmsByPhrase);

        return modelAndView;
    }
    @GetMapping(Mappings.FARM)
    public ModelAndView getFarmByName(@PathVariable("name") String name){

        ModelAndView modelAndView = new ModelAndView("farm");

        Optional<Farm> farm = farmService.showFarmByName(name);
        farm.ifPresent(farm1 -> modelAndView.addObject("farm", farm.get()));
        return modelAndView;
    }
}
