package com.github.ojwm.api.rest.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Vehicle {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String manufacturer;
    protected String model;

    // Getter methods
    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(manufacturer, vehicle.manufacturer) &&
                Objects.equals(model, vehicle.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, model);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this); 
    }
}
