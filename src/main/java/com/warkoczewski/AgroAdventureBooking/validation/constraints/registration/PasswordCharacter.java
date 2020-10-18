package com.warkoczewski.AgroAdventureBooking.validation.constraints.registration;

import com.warkoczewski.AgroAdventureBooking.validation.validators.user.PasswordCharacterValidatorForString;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PasswordCharacterValidatorForString.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordCharacter {
    String message() default "Password must have one upper case character and one digit";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
