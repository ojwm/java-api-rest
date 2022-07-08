package com.github.ojwm.api.rest.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.github.ojwm.api.rest.model.Van;

/**
 * The @RepositoryRestResource annotation tells Spring Data REST
 * to expose this repository.
 * 
 * The PagingAndSortingRepository is an extension of CrudRepository to provide
 * additional methods to retrieve entities using the pagination and sorting abstraction.
 */
@RepositoryRestResource
public interface VanRepository extends PagingAndSortingRepository<Van, Long> {

    /**
     * Define the methods that will be exposed by Spring Data REST,
     * in addition to the defaults.
     * 
     * The JPA query is derived from the method name. See the following documentation:
     * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details
     */
    List<Van> findByManufacturerIgnoreCase(@Param("manufacturer") String manufacturer);
    List<Van> findByModelIgnoreCase(@Param("model") String model);
}
