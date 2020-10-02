package com.warkoczewski.AgroAdventureBooking.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Farm {
    @Id
    private Long farm_Id;
    private String name;
    private String description;
    private boolean isAvailable;

    public Long getFarm_Id() {
        return farm_Id;
    }

    public void setFarm_Id(Long id) {
        this.farm_Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
