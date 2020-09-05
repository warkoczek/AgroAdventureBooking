package com.warkoczewski.AgroAdventureBooking.controller;

import com.warkoczewski.AgroAdventureBooking.model.Point;
import com.warkoczewski.AgroAdventureBooking.repository.PointRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MapController {

    private final PointRepository pointRepository;

    public MapController(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    @GetMapping("/marker")
    public String getMap(Model model){
        model.addAttribute("point", new Point(54.51, 18.53, "Hello Wild Bull", "Pomorskie"));
        return "map";
    }

    @GetMapping("/markers")
    public String getAllFarms(Model model){
        model.addAttribute("points", pointRepository.findAll());
        return "map";
    }

    @GetMapping("/markers/{region}")
    public String getFarmByRegion(@PathVariable("region") String region, Model model){
        model.addAttribute("points", pointRepository.findPointByRegion(region));
        return "map";
    }


}
