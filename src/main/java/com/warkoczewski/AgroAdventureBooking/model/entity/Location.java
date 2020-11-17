package com.warkoczewski.AgroAdventureBooking.model.entity;

import com.sun.istack.NotNull;
import com.warkoczewski.AgroAdventureBooking.model.entity.Farm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long location_Id;

    private double lat;
    private double lon;
    @NotNull
    private String greeting;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "location")
    private Farm farm;


}
