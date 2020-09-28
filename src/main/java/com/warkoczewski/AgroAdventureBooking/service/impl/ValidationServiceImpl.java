package com.warkoczewski.AgroAdventureBooking.service.impl;

import com.warkoczewski.AgroAdventureBooking.repository.UserRepository;
import com.warkoczewski.AgroAdventureBooking.service.ValidationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service @Slf4j @RequiredArgsConstructor
public class ValidationServiceImpl implements ValidationService {

    private final UserRepository userRepository;

    @Override
    public boolean isUniqueUsername(String username) {
        return !userRepository.existsByUsername(username);
    }

    @Override
    public boolean isUniqueEmail(String email) {
        return !userRepository.existsByEmail(email);
    }
}
