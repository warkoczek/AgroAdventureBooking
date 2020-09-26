package com.warkoczewski.AgroAdventureBooking.controller;

import com.warkoczewski.AgroAdventureBooking.dto.RegistrationDataDTO;
import com.warkoczewski.AgroAdventureBooking.service.RegistrationService;
import com.warkoczewski.AgroAdventureBooking.util.Mappings;
import com.warkoczewski.AgroAdventureBooking.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping(Mappings.REGISTER)
    public String getRegistrationPage(){
        return ViewNames.REGISTER;
    }

    @GetMapping(Mappings.REGISTRATION_FORM)
    public String getRegistrationFormPage(Model model){
        model.addAttribute("userDTO", new RegistrationDataDTO());
        return ViewNames.REGISTRATION_FORM;
    }
    @PostMapping(Mappings.REGISTRATION_FORM)
    public String register(@ModelAttribute("userDTO") RegistrationDataDTO registrationDataDTO){
        registrationService.register(registrationDataDTO);
        return "redirect: ";
    }
}
