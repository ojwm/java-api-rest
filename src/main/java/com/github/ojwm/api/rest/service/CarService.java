package com.github.ojwm.api.rest.service;

import org.springframework.stereotype.Service;

import com.github.ojwm.api.rest.model.Car;

@Service
public class CarService {
    
    public Car getCar() {

        return new Car.Builder("Ford")
                .model("Focus")
                .luggageCapacity(375)
                .build();
    }
}
