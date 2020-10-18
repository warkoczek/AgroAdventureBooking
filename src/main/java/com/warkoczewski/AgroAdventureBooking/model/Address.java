package com.warkoczewski.AgroAdventureBooking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address implements Serializable {
    @Id
    @GeneratedValue
    private Long address_Id;
    private String country;
    private String village;
    private String street;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "farm_farm_id", nullable = false)
    private Farm farm;
}
