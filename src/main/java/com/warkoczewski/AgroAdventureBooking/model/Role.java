package com.warkoczewski.AgroAdventureBooking.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
public class Role {
    @Id
    private String behavior;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
}
