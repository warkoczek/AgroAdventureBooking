package com.warkoczewski.AgroAdventureBooking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
    @Id
    private String behavior;
}
