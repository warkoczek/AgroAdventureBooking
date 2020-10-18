package com.warkoczewski.AgroAdventureBooking.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter @Getter
@ToString(exclude = "password", callSuper = true)
@Data
@NoArgsConstructor
public class User implements Serializable {
    @Id
    private String username;

    private String email;

    private boolean active = Boolean.FALSE;

    private String password;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();


}
