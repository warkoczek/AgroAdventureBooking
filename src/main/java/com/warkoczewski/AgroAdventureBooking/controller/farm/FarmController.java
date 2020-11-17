package com.warkoczewski.AgroAdventureBooking.controller.farm;

import com.warkoczewski.AgroAdventureBooking.dto.DisplayFarmDTO;
import com.warkoczewski.AgroAdventureBooking.model.presentation.FarmPage;
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

    @GetMapping("/")
    public String getAllFarms(Model model){
        return showPaginated(1, model);
    }

    @GetMapping(Mappings.ALL_FARMS)
    public String showPaginated(@PathVariable(value = "pageNo")int pageNo,Model model){
        int pageSize = 2;
        FarmPage farmPage = new FarmPage();
        farmPage.setPageNumber(pageNo);
        farmPage.setPageSize(pageSize);
        Page<DisplayFarmDTO> page = farmService.getPaginated(farmPage);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalElements", page.getTotalElements());
        model.addAttribute("allFarms", page.getContent());
        return ViewNames.ALL_FARMS;
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
