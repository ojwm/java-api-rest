package com.github.ojwm.api.rest.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.github.ojwm.api.rest.model.Van;

/**
 * Tests to demonstrate repository usage.
 * There would normally be no need to test JPA functionality.
 * 
 * Normally, the @SpringBootTest annotation would be sufficient
 * but @DataJpaTest is needed to disable JPA auto-configuration.
 */
@DataJpaTest
public class VanRepositoryTest {

    // Use an entity manager to control persistence
    // Not normally required
    @PersistenceContext
    EntityManager entityManager;
    
    @Autowired
    VanRepository vanRepository;

    @Test
    void findByManufacturer() {
        // Define an object
        final Van van = new Van("Ford", "Transit");
        // Persist it
        entityManager.persist(van);
        // Search for it using different case
        final List<Van> vans = vanRepository.findByManufacturerIgnoreCase(van.getManufacturer().toUpperCase());
        // Check the original object was returned by the search
        assertTrue(vans.contains(van));
    }
}
