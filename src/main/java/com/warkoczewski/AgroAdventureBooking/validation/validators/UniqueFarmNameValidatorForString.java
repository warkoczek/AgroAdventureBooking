package com.warkoczewski.AgroAdventureBooking.validation.validators;

import com.warkoczewski.AgroAdventureBooking.dto.BookingDTO;
import com.warkoczewski.AgroAdventureBooking.service.ValidationService;
import com.warkoczewski.AgroAdventureBooking.validation.constraints.booking.UniqueFarmName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@Slf4j
@Scope("prototype")
public class UniqueFarmNameValidatorForString implements ConstraintValidator<UniqueFarmName, BookingDTO> {

    private final ValidationService validationService;

    public UniqueFarmNameValidatorForString(ValidationService validationService) {
        this.validationService = validationService;
    }

    @Override
    public void initialize(UniqueFarmName constraint) {

    }

    @Override
    public boolean isValid(BookingDTO value, ConstraintValidatorContext context) {
        return validationService.isUniqueFarmName(value.getFarmName());
    }
}
