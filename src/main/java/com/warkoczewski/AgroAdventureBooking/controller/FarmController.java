package com.warkoczewski.AgroAdventureBooking.controller;

import com.warkoczewski.AgroAdventureBooking.dto.DisplayFarmDTO;
import com.warkoczewski.AgroAdventureBooking.model.Farm;
import com.warkoczewski.AgroAdventureBooking.service.impl.FarmServiceImpl;
import com.warkoczewski.AgroAdventureBooking.util.Mappings;
import com.warkoczewski.AgroAdventureBooking.util.ViewNames;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FarmController {

    private final FarmServiceImpl farmService;

    public FarmController(FarmServiceImpl farmService) {
        this.farmService = farmService;
    }

    @GetMapping(Mappings.HOME)
    public String getHomePage(){return ViewNames.HOME;}

    @GetMapping(Mappings.ALL_FARMS)
    public ModelAndView getAllFarms(ModelAndView modelAndView){
        return showPaginated(1, modelAndView);
    }

    @GetMapping(Mappings.ALL_FARMS_ID)
    public ModelAndView showPaginated(@PathVariable("pageNo")int pageNo, ModelAndView modelAndView){
        Page<DisplayFarmDTO> page = farmService.getPaginated(pageNo, 2);

        modelAndView.setViewName("farm/allFarms");
        modelAndView.addObject("currentPage", pageNo);
        modelAndView.addObject("totalPages", page.getTotalPages());
        modelAndView.addObject("totalElements", page.getTotalElements());
        modelAndView.addObject("allFarms", page.getContent());
        return modelAndView;
    }

    @GetMapping(Mappings.SEARCH_FARMS)
    public ModelAndView getSearchFarmsPage(ModelAndView modelAndView){
      modelAndView.setViewName(ViewNames.SEARCH_FARMS);
      modelAndView.addObject("farms", farmService.findAll());
        return modelAndView;
    }

    @PostMapping( Mappings.SEARCH_FARMS)
    public ModelAndView searchFarmByPhrase(@RequestParam("phrase") String phrase){
        List<DisplayFarmDTO> farms = farmService.showFarmsByNamePhrase(phrase);
        ModelAndView modelAndView = new ModelAndView(ViewNames.SEARCH_FARMS);
        modelAndView.addObject("farms", farms);
        return modelAndView;
    }
    @GetMapping(Mappings.FARM)
    public ModelAndView getFarmByName(@PathVariable("name") String name){

        ModelAndView modelAndView = new ModelAndView("/main/resources/templates/farm/farm.html");

        DisplayFarmDTO farm = farmService.showFarmByName(name);
         modelAndView.addObject("farm", farm);
        return modelAndView;
    }


    @GetMapping(Mappings.DELETE_FARM)
    public String deleteBooking(@PathVariable("booking_Id") Long id){
        farmService.deleteFarm(id);
        return ViewNames.FARM_DELETED;
    }


}
