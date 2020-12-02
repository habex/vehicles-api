package com.udacity.orders_sales.domain;

import com.udacity.orders_sales.client.maps.Address;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    //Customer Address
    @Valid
    @Embedded
    private Location location = new Location(0d, 0d);

    public Customer() {
    }

    public Customer(int id, @NotNull String name, @Valid Location location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
