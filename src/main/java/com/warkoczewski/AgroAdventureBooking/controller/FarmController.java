package com.warkoczewski.AgroAdventureBooking.controller;

import com.warkoczewski.AgroAdventureBooking.dto.DisplayFarmDTO;
import com.warkoczewski.AgroAdventureBooking.dto.FarmDTO;
import com.warkoczewski.AgroAdventureBooking.service.impl.FarmServiceImpl;
import com.warkoczewski.AgroAdventureBooking.util.Mappings;
import com.warkoczewski.AgroAdventureBooking.util.ViewNames;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FarmController {

    private final FarmServiceImpl farmServiceImpl;

    public FarmController(FarmServiceImpl farmServiceImpl) {
        this.farmServiceImpl = farmServiceImpl;
    }

    @GetMapping(Mappings.HOME)
    public String getHomePage(){
        return ViewNames.HOME;
    }
    @GetMapping(Mappings.ALL_FARMS)
    public ModelAndView showAllFarms(ModelAndView modelAndView){
        List<DisplayFarmDTO> allFarms = farmServiceImpl.findAll();
        modelAndView.setViewName("farm/allFarms");
        modelAndView.addObject("allFarms", allFarms);
        return modelAndView;
    }

    @GetMapping(Mappings.SEARCH_FARMS)
    public ModelAndView getSearchFarmsPage(ModelAndView modelAndView){
      modelAndView.setViewName(ViewNames.SEARCH_FARMS);
      modelAndView.addObject("farms", farmServiceImpl.findAll());
        return modelAndView;
    }

    @PostMapping( Mappings.SEARCH_FARMS)
    public ModelAndView searchFarmByPhrase(@RequestParam("phrase") String phrase){
        List<DisplayFarmDTO> farms = farmServiceImpl.showFarmsByNamePhrase(phrase);
        ModelAndView modelAndView = new ModelAndView(ViewNames.SEARCH_FARMS);
        modelAndView.addObject("farms", farms);
        return modelAndView;
    }
    @GetMapping(Mappings.FARM)
    public ModelAndView getFarmByName(@PathVariable("name") String name){

        ModelAndView modelAndView = new ModelAndView("/main/resources/templates/farm/farm.html");

        DisplayFarmDTO farm = farmServiceImpl.showFarmByName(name);
         modelAndView.addObject("farm", farm);
        return modelAndView;
    }
    @PostMapping()
    public String addFarm(@ModelAttribute FarmDTO farmDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ViewNames.ADD_FARM;
        }
        farmServiceImpl.createFarm(farmDTO);
        return ViewNames.FARM_CREATED;
    }

    @GetMapping(Mappings.DELETE_FARM)
    public String deleteBooking(@PathVariable("booking_Id") Long id){
        farmServiceImpl.deleteFarm(id);
        return ViewNames.FARM_DELETED;
    }

}
