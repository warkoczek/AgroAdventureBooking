package com.warkoczewski.AgroAdventureBooking.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
public class Role {
    @Id
    private String behavior;
}
