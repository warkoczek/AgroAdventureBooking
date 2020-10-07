package com.warkoczewski.AgroAdventureBooking.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Localization {
    @Id
    private Long id;
    private String country;
    private String city;
    private String street;
    @OneToOne
    private Farm farm;
}
