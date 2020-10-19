package com.warkoczewski.AgroAdventureBooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDTO {

    private double lat;
    private double lon;
    private String greeting;
}
