package com.warkoczewski.AgroAdventureBooking.model;

import com.warkoczewski.AgroAdventureBooking.model.entity.Booking;
import com.warkoczewski.AgroAdventureBooking.model.entity.Role;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter @Getter
@ToString(exclude = "password", callSuper = true)
@Data
@NoArgsConstructor
public class User {
    @Id
    private String username;

    private String email;

    private boolean active = Boolean.FALSE;

    private String password;

    @OneToMany
    private Set<Booking> booking;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();


}
