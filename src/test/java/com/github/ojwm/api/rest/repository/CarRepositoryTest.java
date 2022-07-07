package com.github.ojwm.api.rest.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.github.ojwm.api.rest.model.Car;

@DataJpaTest
public class CarRepositoryTest {

    @PersistenceContext
    EntityManager entityManager;
    
    @Autowired
    CarRepository carRepository;

    @Test
    void findByManufacturer() {
        final Car car = new Car("Ford", "Focus");
        entityManager.persist(car);
        final List<Car> cars = carRepository.findByManufacturerIgnoreCase(car.getManufacturer().toUpperCase());
        assertTrue(cars.contains(car));
    }
}
