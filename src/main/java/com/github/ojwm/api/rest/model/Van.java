package com.github.ojwm.api.rest.model;

public class Van extends Vehicle {

    // Attributes
    private Integer cargoCapacity;

    // Getter methods
    public Integer getCargoCapacity() {
        return cargoCapacity;
    }
    
    // Private constructor
    private Van(Builder builder) {
        this.manufacturer = builder.manufacturer;
        this.model = builder.model;
        this.cargoCapacity = builder.cargoCapacity;
    }

    // Builder class - using Joshua Bloch’s builder pattern
    public static class Builder {

        private final String manufacturer;
        private String model;
        private Integer cargoCapacity;

        public Builder(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder cargoCapacity(Integer cargoCapacity) {
            this.cargoCapacity = cargoCapacity;
            return this;
        }

        public Van build() {
            return new Van(this);
        }
    }
}
