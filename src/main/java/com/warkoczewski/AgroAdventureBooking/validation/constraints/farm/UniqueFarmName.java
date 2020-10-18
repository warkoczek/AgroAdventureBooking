package com.warkoczewski.AgroAdventureBooking.validation.constraints.farm;

import com.warkoczewski.AgroAdventureBooking.validation.validators.farm.UniqueFarmNameValidatorForString;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Constraint(validatedBy = UniqueFarmNameValidatorForString.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface UniqueFarmName {
}
