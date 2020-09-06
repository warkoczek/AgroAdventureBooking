package com.warkoczewski.AgroAdventureBooking.controller;

import com.warkoczewski.AgroAdventureBooking.model.Point;
import com.warkoczewski.AgroAdventureBooking.repository.PointRepository;
import com.warkoczewski.AgroAdventureBooking.util.Mappings;
import com.warkoczewski.AgroAdventureBooking.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class MapController {

    private final PointRepository pointRepository;

    public MapController(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    @GetMapping(Mappings.MARKER)
    public String getMap(Model model){
        model.addAttribute("point", new Point(54.51, 18.53, "Hello Wild Bull", "Pomorskie"));
        return ViewNames.MAP_TEST_MARKER;
    }

    @GetMapping(Mappings.MARKERS)
    public String getAllFarms(Model model){
        model.addAttribute("points", pointRepository.findAll());
        return ViewNames.MAP;
    }

    @GetMapping(Mappings.MARKERS_REGION)
    public String getFarmByRegion(@PathVariable("region") String region, Model model){
        model.addAttribute("points", pointRepository.findPointByRegion(region));
        return ViewNames.MAP;
    }


}
