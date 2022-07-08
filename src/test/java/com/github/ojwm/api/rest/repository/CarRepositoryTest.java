package com.github.ojwm.api.rest.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.github.ojwm.api.rest.model.Car;

/**
 * Tests to demonstrate repository usage.
 * There would normally be no need to test JPA functionality.
 * 
 * Normally, the @SpringBootTest annotation would be sufficient
 * but @DataJpaTest is needed to disable JPA auto-configuration.
 */
@DataJpaTest
public class CarRepositoryTest {

    // Use an entity manager to control persistence
    // Not normally required
    @PersistenceContext
    EntityManager entityManager;
    
    @Autowired
    CarRepository carRepository;

    @Test
    void findByManufacturer() {
        // Define an object
        final Car car = new Car("Ford", "Focus");
        // Persist it
        entityManager.persist(car);
        // Search for it using different case
        final List<Car> cars = carRepository.findByManufacturerIgnoreCase(car.getManufacturer().toUpperCase());
        // Check the original object was returned by the search
        assertTrue(cars.contains(car));
    }
}
