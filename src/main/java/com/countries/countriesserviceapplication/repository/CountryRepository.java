package com.countries.countriesserviceapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.countries.countriesserviceapplication.model.Country;
@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
    
}
