package com.warkoczewski.AgroAdventureBooking.controller;
import com.warkoczewski.AgroAdventureBooking.service.impl.AddressServiceImpl;
import com.warkoczewski.AgroAdventureBooking.util.Mappings;
import com.warkoczewski.AgroAdventureBooking.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AddressController {
    private final AddressServiceImpl addressServiceImpl;

    public AddressController(AddressServiceImpl addressServiceImpl) {
        this.addressServiceImpl = addressServiceImpl;
    }

    @GetMapping(Mappings.DELETE_ADDRESS)
    public String deleteAddress(@PathVariable("address_Id") Long id){
        addressServiceImpl.deleteAddress(id);
        return ViewNames.ADDRESS_DELETED;
    }
}
