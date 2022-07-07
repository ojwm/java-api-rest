package com.github.ojwm.api.rest.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.github.ojwm.api.rest.model.Car;

@RepositoryRestResource
public interface CarRepository extends PagingAndSortingRepository<Car, Long> {

    List<Car> findByManufacturerIgnoreCase(@Param("manufacturer") String manufacturer);
    List<Car> findByModelIgnoreCase(@Param("model") String model);
}
