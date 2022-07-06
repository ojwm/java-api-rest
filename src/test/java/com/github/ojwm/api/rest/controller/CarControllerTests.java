package com.github.ojwm.api.rest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.github.ojwm.api.rest.model.Car;
import com.github.ojwm.api.rest.service.CarService;

@SpringBootTest
public class CarControllerTests {

    @Autowired
    CarController carController;

    @Mock
    CarService carService;

    @Test
    void getCar() {

        final Car car = new Car.Builder("Ford")
                .model("Focus")
                .build();
        final ResponseEntity<Car> expected = new ResponseEntity<Car>(car, HttpStatus.OK);
        when(carService.getCar()).thenReturn(car);
        final ResponseEntity<Car> actual = carController.getCar();

        assertEquals(expected, actual);
    }
}
