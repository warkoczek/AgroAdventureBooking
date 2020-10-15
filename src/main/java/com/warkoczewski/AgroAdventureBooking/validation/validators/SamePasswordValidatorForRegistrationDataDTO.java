package com.warkoczewski.AgroAdventureBooking.validation.validators;

import com.warkoczewski.AgroAdventureBooking.dto.RegistrationDataDTO;
import com.warkoczewski.AgroAdventureBooking.validation.constraints.registration.SamePassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SamePasswordValidatorForRegistrationDataDTO implements ConstraintValidator<SamePassword, RegistrationDataDTO> {

    public void initialize(SamePassword constraint){}

    @Override
    public boolean isValid(RegistrationDataDTO registrationDataDTO, ConstraintValidatorContext context) {
            if (registrationDataDTO.getPassword() == null || registrationDataDTO.getRePassword() == null){
                return true;
            }else{
                boolean valid = registrationDataDTO.getPassword().equals(registrationDataDTO.getRePassword());
                if(!valid){
                    context.disableDefaultConstraintViolation();
                    context.buildConstraintViolationWithTemplate("Passwords must match")
                    .addPropertyNode("rePassword").addConstraintViolation();
                }
                return valid;

            }
    }
}
