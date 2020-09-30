package com.warkoczewski.AgroAdventureBooking.validation.constraints;

import com.warkoczewski.AgroAdventureBooking.validation.validators.SamePasswordValidatorForRegistrationDataDTO;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Constraint(validatedBy = SamePasswordValidatorForRegistrationDataDTO.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SamePassword {
}
