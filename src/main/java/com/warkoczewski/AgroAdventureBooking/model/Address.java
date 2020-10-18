package com.warkoczewski.AgroAdventureBooking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long address_Id;
    private String country;
    private String village;
    private String street;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_Id", nullable = false)
    private Farm farm;
}
