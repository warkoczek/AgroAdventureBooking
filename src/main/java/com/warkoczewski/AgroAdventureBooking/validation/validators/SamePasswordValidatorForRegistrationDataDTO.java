package com.warkoczewski.AgroAdventureBooking.validation.validators;

import com.warkoczewski.AgroAdventureBooking.dto.RegistrationDataDTO;
import com.warkoczewski.AgroAdventureBooking.validation.constraints.SamePassword;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Component
@Scope("prototype")
@Slf4j
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
                    context.buildConstraintViolationWithTemplate("SamePassword.registrationDataDTO.rePassword")
                    .addPropertyNode("rePassword").addConstraintViolation();
                }
                return valid;

            }
    }
}
