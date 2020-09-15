package com.warkoczewski.AgroAdventureBooking.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Location {

    @Id
    private Long loc_Id;

    private double lat;
    private double lon;
    private String greeting;

    public Long getLoc_Id() {
        return loc_Id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return Double.compare(location.lat, lat) == 0 &&
                Double.compare(location.lon, lon) == 0 &&
                Objects.equals(loc_Id, location.loc_Id) &&
                Objects.equals(greeting, location.greeting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loc_Id, lat, lon, greeting);
    }
}
