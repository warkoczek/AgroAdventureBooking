package com.warkoczewski.AgroAdventureBooking.controller.contact;

import com.warkoczewski.AgroAdventureBooking.dto.ContactDTO;
import com.warkoczewski.AgroAdventureBooking.service.impl.ContactServiceImpl;
import com.warkoczewski.AgroAdventureBooking.util.Mappings;
import com.warkoczewski.AgroAdventureBooking.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(Mappings.CONTACT_US)
public class ContactController {
    private final ContactServiceImpl contactService;

    public ContactController(ContactServiceImpl contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public String getContactUsPage(Model model){
        model.addAttribute("contactDTO", new ContactDTO());
        return ViewNames.CONTACT_US;
    }
    @PostMapping
    public ModelAndView processContactUsForm(@ModelAttribute("contactDTO") @Valid ContactDTO contactDTO, BindingResult bindingResult, ModelAndView modelAndView){
        if(bindingResult.hasErrors()){
            modelAndView.setViewName(ViewNames.CONTACT_US);
            return modelAndView;
        }
        contactService.sendEmail(contactDTO);
        modelAndView.setViewName(ViewNames.CONTACT_SUCCESS);
        modelAndView.addObject("message", "Email sent successfully!!!");
        return modelAndView;

    }

}
