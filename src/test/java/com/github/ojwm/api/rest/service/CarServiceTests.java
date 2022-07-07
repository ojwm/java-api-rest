package com.github.ojwm.api.rest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.ojwm.api.rest.model.Car;

@SpringBootTest
public class CarServiceTests {
    
    @Autowired
    private CarService carService;

    @Test
    void getCar() {
        final Car expected = new Car.Builder("Ford")
                .model("Focus")
                .luggageCapacity(375)
                .build();
        final Car actual = carService.getCar();

        assertEquals(expected, actual);
    }
}
