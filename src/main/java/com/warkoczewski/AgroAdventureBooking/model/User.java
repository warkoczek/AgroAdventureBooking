package com.warkoczewski.AgroAdventureBooking.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter @Getter
@ToString(exclude = "password", callSuper = true)
public class User {
    @Id
    private String username;

    private String email;

    private boolean active = Boolean.FALSE;

    private String password;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();


}
