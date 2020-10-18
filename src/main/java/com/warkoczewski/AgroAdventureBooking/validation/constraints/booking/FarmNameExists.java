package com.warkoczewski.AgroAdventureBooking.validation.constraints.booking;

import com.warkoczewski.AgroAdventureBooking.validation.validators.farm.FarmNameExistsValidatorForString;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = FarmNameExistsValidatorForString.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface FarmNameExists {
    String message() default "No farm with such a name exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
