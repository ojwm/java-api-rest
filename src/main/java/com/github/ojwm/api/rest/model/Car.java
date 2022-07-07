package com.github.ojwm.api.rest.model;

public class Car extends Vehicle {

    // Attributes
    private Integer luggageCapacity;

    // Getter methods
    public Integer getLuggageCapacity() {
        return luggageCapacity;
    }
    
    // Private constructor
    private Car(Builder builder) {
        this.manufacturer = builder.manufacturer;
        this.model = builder.model;
        this.luggageCapacity = builder.luggageCapacity;
    }

    // Builder class - using Joshua Bloch’s builder pattern
    public static class Builder {

        private final String manufacturer;
        private String model;
        private Integer luggageCapacity;

        public Builder(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder luggageCapacity(Integer luggageCapacity) {
            this.luggageCapacity = luggageCapacity;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
