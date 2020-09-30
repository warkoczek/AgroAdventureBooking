package com.warkoczewski.AgroAdventureBooking.validation.validators;

import com.warkoczewski.AgroAdventureBooking.dto.RegistrationDataDTO;
import com.warkoczewski.AgroAdventureBooking.validation.constraints.SamePassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SamePasswordValidatorForRegistrationDataDTO implements ConstraintValidator<SamePassword, RegistrationDataDTO> {

    public void initialize(SamePassword constraint){}

    @Override
    public boolean isValid(RegistrationDataDTO registrationDataDTO, ConstraintValidatorContext context) {
            if (registrationDataDTO.getPassword() == null || registrationDataDTO.getRePassword() == null){
                return true;
            }
        return false;
    }
}
