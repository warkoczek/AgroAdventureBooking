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


@Controller
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping(Mappings.REGISTRATION_FORM)
    public String getRegistrationFormPage(Model model){
        model.addAttribute("userDTO", new RegistrationDataDTO());
        return ViewNames.REGISTRATION_FORM;
    }
    @PostMapping(Mappings.REGISTRATION_FORM)
    public String register(@ModelAttribute("userDTO") RegistrationDataDTO registrationDataDTO){
        //todo validation and success page
        registrationService.register(registrationDataDTO);
        return  "redirect: /register/registrationForm?success";
    }
}
