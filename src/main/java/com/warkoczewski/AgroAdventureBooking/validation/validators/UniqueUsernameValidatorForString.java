package com.warkoczewski.AgroAdventureBooking.validation.validators;

import com.warkoczewski.AgroAdventureBooking.service.ValidationService;
import com.warkoczewski.AgroAdventureBooking.validation.constraints.UniqueUsername;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@Scope("prototype")
@Slf4j
public class UniqueUsernameValidatorForString implements ConstraintValidator<UniqueUsername, String> {

    private ValidationService validationService;

    public UniqueUsernameValidatorForString(ValidationService validationService) {
        this.validationService = validationService;
    }

    public void initialize(UniqueUsername constraint){
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.debug("Validating unique username {}", value);
        boolean unique = validationService.isUniqueUsername(value);
        log.debug("Is username '{}' unique? {}", value, unique);
        return unique;
    }
}
