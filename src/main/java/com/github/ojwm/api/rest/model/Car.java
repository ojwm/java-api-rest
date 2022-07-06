package com.github.ojwm.api.rest.model;

import java.util.Objects;

public class Car {

    // Attributes
    private final String manufacturer;
    private final String model;

    // Private constructor
    private Car(Builder builder) {
        this.manufacturer = builder.manufacturer;
        this.model = builder.model;
    }

    // Getter methods
    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    // Builder class - using Joshua Bloch’s builder pattern
    public static class Builder {

        private final String manufacturer;
        private String model;

        public Builder(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Car)) return false;
        Car vehicle = (Car) o;
        return Objects.equals(manufacturer, vehicle.manufacturer) &&
                Objects.equals(model, vehicle.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, model);
    }
}
