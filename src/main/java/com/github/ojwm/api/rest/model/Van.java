package com.github.ojwm.api.rest.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Van extends Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private Integer cargoCapacity;

    public Van(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public long getId() {
        return id;
    }
    
    public Integer getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(Integer cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Van)) return false;
        Van van = (Van) o;
        return Objects.equals(manufacturer, van.manufacturer) &&
                Objects.equals(model, van.model) &&
                Objects.equals(cargoCapacity, van.cargoCapacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, model, cargoCapacity);
    }
}
