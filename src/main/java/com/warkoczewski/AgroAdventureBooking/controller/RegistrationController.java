package com.warkoczewski.AgroAdventureBooking.controller;

import com.warkoczewski.AgroAdventureBooking.dto.LoginDataDTO;
import com.warkoczewski.AgroAdventureBooking.dto.RegistrationDataDTO;
import com.warkoczewski.AgroAdventureBooking.service.RegistrationService;
import com.warkoczewski.AgroAdventureBooking.util.Mappings;
import com.warkoczewski.AgroAdventureBooking.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


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
    public String register(@Valid @ModelAttribute("userDTO") RegistrationDataDTO registrationDataDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ViewNames.REGISTRATION_FORM;
        }

        registrationService.register(registrationDataDTO);
        return  "register/registrationSuccess";
    }

    @GetMapping(Mappings.LOGIN)
    public String getLoginPage(Model model){
        model.addAttribute("loginDTO", new LoginDataDTO());
        return ViewNames.LOGIN;
    }
}
