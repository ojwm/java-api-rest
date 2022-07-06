package com.github.ojwm.api.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.ojwm.api.rest.model.Car;
import com.github.ojwm.api.rest.service.CarService;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping(value = "/car")
    public ResponseEntity<Car> getCar() {
        return new ResponseEntity<>(carService.getCar(), HttpStatus.OK);
    }
}
