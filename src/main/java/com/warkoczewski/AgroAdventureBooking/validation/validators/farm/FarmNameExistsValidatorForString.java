package com.warkoczewski.AgroAdventureBooking.validation.validators.farm;

import com.warkoczewski.AgroAdventureBooking.service.ValidationService;
import com.warkoczewski.AgroAdventureBooking.validation.constraints.booking.FarmNameExists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@Slf4j
@Scope("prototype")
public class FarmNameExistsValidatorForString implements ConstraintValidator<FarmNameExists, String> {

    private final ValidationService validationService;

    public FarmNameExistsValidatorForString(ValidationService validationService) {
        this.validationService = validationService;
    }

    @Override
    public void initialize(FarmNameExists constraint) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return validationService.farmNameExists(value);
    }

}
