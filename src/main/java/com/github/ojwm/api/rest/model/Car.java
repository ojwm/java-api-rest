package com.github.ojwm.api.rest.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car extends Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private Integer luggageCapacity;

    public Car(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public long getId() {
        return id;
    }
    
    public Integer getLuggageCapacity() {
        return luggageCapacity;
    }

    public void setLuggageCapacity(Integer luggageCapacity) {
        this.luggageCapacity = luggageCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(manufacturer, car.manufacturer) &&
                Objects.equals(model, car.model) &&
                Objects.equals(luggageCapacity, car.luggageCapacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, model, luggageCapacity);
    }
}
