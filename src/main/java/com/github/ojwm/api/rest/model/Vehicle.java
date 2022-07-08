package com.github.ojwm.api.rest.model;

import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Vehicle abstract class
 * 
 * The @MappedSuperclass annotation allows JPA to map this
 * class' attributes on any child entity, without this class
 * having to be an entity with its own table.
 */
@MappedSuperclass
public abstract class Vehicle {

    // Attributes
    protected String manufacturer;
    protected String model;

    // Getter methods
    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    /**
     * Custom toString method
     * 
	 * @return String representation of the vehicle
     */
    @Override
    public String toString() {
        // ToStringBuilder automatically creates a consistent string structure
        return ToStringBuilder.reflectionToString(this); 
    }
}
