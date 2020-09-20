package com.warkoczewski.AgroAdventureBooking.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private String username;

    private String email;

    private boolean active = Boolean.FALSE;

    private String password;


}
