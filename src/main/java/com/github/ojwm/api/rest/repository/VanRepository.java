package com.github.ojwm.api.rest.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.github.ojwm.api.rest.model.Van;

@RepositoryRestResource
public interface VanRepository extends PagingAndSortingRepository<Van, Long> {

    List<Van> findByManufacturer(@Param("manufacturer") String manufacturer);
}
