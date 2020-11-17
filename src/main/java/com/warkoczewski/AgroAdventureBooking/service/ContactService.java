package com.warkoczewski.AgroAdventureBooking.service;

import com.warkoczewski.AgroAdventureBooking.dto.ContactDTO;

public interface ContactService {
    void sendEmail(ContactDTO contactDTO);
}
