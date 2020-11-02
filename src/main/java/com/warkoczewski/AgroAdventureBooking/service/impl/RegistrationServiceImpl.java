package com.warkoczewski.AgroAdventureBooking.service.impl;

import com.warkoczewski.AgroAdventureBooking.dto.RegistrationDataDTO;

import com.warkoczewski.AgroAdventureBooking.model.entity.Role;
import com.warkoczewski.AgroAdventureBooking.model.User;
import com.warkoczewski.AgroAdventureBooking.repository.RoleRepository;
import com.warkoczewski.AgroAdventureBooking.repository.UserRepository;
import com.warkoczewski.AgroAdventureBooking.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Slf4j
@Validated
@Transactional
public class RegistrationServiceImpl implements RegistrationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final ModelMapper modelMapper;

    public RegistrationServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository, ModelMapper modelMapper) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public void register( RegistrationDataDTO registrationData) {
        log.debug("Registration data to create a new user: {}", registrationData);
        User user = modelMapper.map(registrationData, User.class);
        log.debug("User after mapping from registrationData: {}", user);
        user.setActive(Boolean.TRUE);
        String encodedPassword = passwordEncoder.encode(registrationData.getPassword());
        user.setPassword(encodedPassword);
        Role role = roleRepository.getRoleByBehavior("client");
        user.getRoles().add(role);
        log.debug("User before save: {}", user);
        userRepository.save(user);
        log.debug("User after save: {}", user);

    }
}
