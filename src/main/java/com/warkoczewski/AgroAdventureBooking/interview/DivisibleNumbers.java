package com.warkoczewski.AgroAdventureBooking.interview;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DivisibleNumbers {
    @EventListener(ApplicationReadyEvent.class)
    public void printAndMarkDivisibleNumbers(){
        for(int i = 1; i <=100; i++){
            if(i %3 == 0){
                System.out.println(i + " foo");
            }
            if(i %5 == 0){
                System.out.println(i + " boo");
            }
            if( i %3 == 0 && i%5 == 0){
                System.out.println(i + " foo and boo");
            }else{
                System.out.println(i);
            }
        }
    }
}
