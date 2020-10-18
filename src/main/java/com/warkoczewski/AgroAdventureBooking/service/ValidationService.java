package com.warkoczewski.AgroAdventureBooking.service;

public interface ValidationService {
    boolean isUniqueUsername(String username);
    boolean isUniqueEmail(String email);
    boolean farmNameExists(String farmName);
    boolean isUniqueFarmName(String farmName);


}
