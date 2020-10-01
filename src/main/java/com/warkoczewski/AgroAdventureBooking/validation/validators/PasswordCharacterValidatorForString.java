package com.warkoczewski.AgroAdventureBooking.validation.validators;

import com.warkoczewski.AgroAdventureBooking.validation.constraints.PasswordCharacter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Component
@Slf4j
@Scope("prototype")
public class PasswordCharacterValidatorForString implements ConstraintValidator<PasswordCharacter, String> {

    public void initialize(PasswordCharacter constraint){

    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.debug("Checking if password has one upper case letter and one number: {}", value);
            if(hasOneUpperCase(value) && hasOneNumber(value)){
                return true;
            }
        return false;
    }

    public static boolean hasOneUpperCase(String value){
        for(char character : value.toCharArray()){
            if(Character.isUpperCase(character)){
                return true;
            }
        }
        return false;
    }

    public static boolean hasOneNumber(String value){
        for(char character : value.toCharArray()){
            if(Character.isDigit(character)){
                return true;
            }
        }
        return false;
    }
}
