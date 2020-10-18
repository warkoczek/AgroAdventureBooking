package com.warkoczewski.AgroAdventureBooking.service;

import com.warkoczewski.AgroAdventureBooking.dto.AddressDTO;
import com.warkoczewski.AgroAdventureBooking.model.Address;

public interface AddressService {
    Address createAddress(AddressDTO addressDTO);
    void deleteAddress(Long id);
}
