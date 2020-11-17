package com.warkoczewski.AgroAdventureBooking.controller.exception;

import com.warkoczewski.AgroAdventureBooking.exception.FarmNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = FarmNotFoundException.class)
    public ModelAndView handleFarmNotFoundException(FarmNotFoundException farmException){
        ModelAndView modelAndView = new ModelAndView("FarmNotFoundException");
        modelAndView.addObject("farmException", farmException.getMessage());
        return modelAndView;
    }
}
