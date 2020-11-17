package com.warkoczewski.AgroAdventureBooking.controller.contact;

import com.warkoczewski.AgroAdventureBooking.dto.ContactDTO;
import com.warkoczewski.AgroAdventureBooking.util.Mappings;
import com.warkoczewski.AgroAdventureBooking.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(Mappings.CONTACT_US)
public class ContactController {

    @GetMapping
    public String getContactUsPage(Model model){
        model.addAttribute("blank","Blank for now");
        return ViewNames.CONTACT_US;
    }
    @PostMapping
    public String processContactUsForm(@RequestBody ContactDTO contactDTO){

        return ViewNames.CONTACT_US;
    }

}
