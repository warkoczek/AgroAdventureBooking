package com.warkoczewski.AgroAdventureBooking.validation.validators.farm;

import com.warkoczewski.AgroAdventureBooking.service.ValidationService;
import com.warkoczewski.AgroAdventureBooking.validation.constraints.farm.UniqueFarmName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueFarmNameValidatorForString implements ConstraintValidator<UniqueFarmName, String> {
    private final ValidationService validationService;

    public UniqueFarmNameValidatorForString(ValidationService validationService) {
        this.validationService = validationService;
    }

    @Override
    public void initialize(UniqueFarmName constraint) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return validationService.isUniqueFarmName(value);
    }

}
