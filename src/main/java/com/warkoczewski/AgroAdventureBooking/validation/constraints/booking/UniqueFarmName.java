package com.warkoczewski.AgroAdventureBooking.validation.constraints.booking;

import com.warkoczewski.AgroAdventureBooking.validation.validators.UniqueFarmNameValidatorForString;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueFarmNameValidatorForString.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface UniqueFarmName {
    String message() default "Farm name must be unique";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
