package com.warkoczewski.AgroAdventureBooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
@Entity
public class Farm {
    @Id
    private Long farm_Id;
    private String name;
    private String description;
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isAvailable;
    @OneToMany
    private Set<Booking> booking;


}
