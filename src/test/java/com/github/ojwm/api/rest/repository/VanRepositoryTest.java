package com.github.ojwm.api.rest.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.github.ojwm.api.rest.model.Van;

@DataJpaTest
public class VanRepositoryTest {

    @PersistenceContext
    EntityManager entityManager;
    
    @Autowired
    VanRepository vanRepository;

    @Test
    void findByManufacturer() {
        final Van van = new Van("Ford", "Transit");
        entityManager.persist(van);
        final List<Van> vans = vanRepository.findByManufacturerIgnoreCase(van.getManufacturer().toUpperCase());
        assertTrue(vans.contains(van));
    }
}
