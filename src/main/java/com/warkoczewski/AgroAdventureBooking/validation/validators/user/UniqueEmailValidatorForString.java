package com.warkoczewski.AgroAdventureBooking.validation.validators.user;


import com.warkoczewski.AgroAdventureBooking.service.ValidationService;
import com.warkoczewski.AgroAdventureBooking.validation.constraints.registration.UniqueEmail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Component
@Scope("prototype")
@Slf4j
public class UniqueEmailValidatorForString implements ConstraintValidator<UniqueEmail, String> {


    private ValidationService validationService;

    public UniqueEmailValidatorForString(ValidationService validationService) {
        this.validationService = validationService;
    }

    public void initialize(UniqueEmail constraint) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.debug("Validating unique email: {}", value);
        boolean unique = validationService.isUniqueEmail(value);
        log.debug("Is email '{}' unique? {}", value, unique);
        return unique;
    }

}
