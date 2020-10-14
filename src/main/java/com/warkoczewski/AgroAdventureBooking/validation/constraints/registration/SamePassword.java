package com.warkoczewski.AgroAdventureBooking.validation.constraints.registration;

import com.warkoczewski.AgroAdventureBooking.validation.validators.SamePasswordValidatorForRegistrationDataDTO;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Constraint(validatedBy = SamePasswordValidatorForRegistrationDataDTO.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SamePassword {
    String message() default "Password must be the same";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
