package com.github.ojwm.api.rest.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Car class
 * 
 * The @Entity annotation tells JPA to map this
 * class to its own table.
 */
@Entity
public class Car extends Vehicle {

    // @Id annotation tells JPA this is the primary key
    // @GeneratedValue annotation tells JPA how to generate the primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private Integer luggageCapacity;

    // Default constructor
    public Car(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    // Getter and setter methods
    // Spring Boot Data uses these to map to the repository
    public long getId() {
        return id;
    }
    
    public Integer getLuggageCapacity() {
        return luggageCapacity;
    }

    public void setLuggageCapacity(Integer luggageCapacity) {
        this.luggageCapacity = luggageCapacity;
    }

    /**
     * Equals method
     * 
     * @return true if the objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(manufacturer, car.manufacturer) &&
                Objects.equals(model, car.model) &&
                Objects.equals(luggageCapacity, car.luggageCapacity);
    }

    /**
     * Generate the object's hash code
     * 
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, model, luggageCapacity);
    }
}
