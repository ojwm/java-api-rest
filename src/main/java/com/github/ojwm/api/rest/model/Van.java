package com.github.ojwm.api.rest.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Van class
 * 
 * The @Entity annotation tells JPA to map this
 * class to its own table.
 */
@Entity
public class Van extends Vehicle {

    // @Id annotation tells JPA this is the primary key
    // @GeneratedValue annotation tells JPA how to generate the primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private Integer cargoCapacity;

    // Default constructor
    public Van(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    // Getter and setter methods
    // Spring Boot Data uses these to map to the repository
    public long getId() {
        return id;
    }
    
    public Integer getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(Integer cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    /**
     * Equals method
     * 
     * @return true if the objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Van)) return false;
        Van van = (Van) o;
        return Objects.equals(manufacturer, van.manufacturer) &&
                Objects.equals(model, van.model) &&
                Objects.equals(cargoCapacity, van.cargoCapacity);
    }

    /**
     * Generate the object's hash code
     * 
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, model, cargoCapacity);
    }
}
