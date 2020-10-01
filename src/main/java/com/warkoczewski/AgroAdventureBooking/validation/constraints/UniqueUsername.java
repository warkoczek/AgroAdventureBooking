package com.warkoczewski.AgroAdventureBooking.validation.constraints;

import com.warkoczewski.AgroAdventureBooking.validation.validators.UniqueUsernameValidatorForString;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Constraint(validatedBy = UniqueUsernameValidatorForString.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUsername {
    String message() default "Username must be unique";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
