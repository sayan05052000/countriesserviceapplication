package com.countries.countriesserviceapplication.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.countries.countriesserviceapplication.exception.CountryExistsException;
import com.countries.countriesserviceapplication.exception.CountryNotFoundException;
import com.countries.countriesserviceapplication.model.Country;
import com.countries.countriesserviceapplication.repository.CountryRepository;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;
    
    public List<Country> loadInitializeData(){ 
        return countryRepository.findAll();
    }
    public List<Country> loadData(int pageNo,int pageSize){
        PageRequest pageRequest=PageRequest.of(pageNo, pageSize);
        Page<Country> page=countryRepository.findAll(pageRequest);
        return page.getContent();
    }
    
    public ResponseEntity<Object> addData(String countryName,String primeMinister){
        boolean alreadyPresent=false;
        for(Country country:countryRepository.findAll()){
            if(country.getCountryName().equalsIgnoreCase(countryName)){
                alreadyPresent=true;
            }
        }
        if(!alreadyPresent){
            countryRepository.save(new Country(countryRepository.findAll().size()+1, countryName, primeMinister));
            return new ResponseEntity<>("Country added successFully.Please return to home page to view",HttpStatus.OK);
        }else{
            throw new CountryExistsException();
        }
    }

    public List<Country> findPaginatedByCountryName(int pageNo,int pageSize,String countryName) {
        PageRequest pageRequest=PageRequest.of(pageNo, pageSize);
        Page<Country> page=countryRepository.findAll(pageRequest);
        List<Country> countryList=new ArrayList<>();
        for(Country country:page.getContent()){
            if(country.getCountryName().toLowerCase().contains(countryName.toLowerCase())){
                countryList.add(country);
            }
        }
        if(countryList.isEmpty()){
            throw new CountryNotFoundException();
        }
        return countryList;
    }

    public List<Country> findPaginatedByPrimeMinister(int pageNo,int pageSize,String primeMinister) {
        PageRequest pageRequest=PageRequest.of(pageNo, pageSize);
        Page<Country> page=countryRepository.findAll(pageRequest);
        List<Country> countryList=new ArrayList<>();
        for(Country country:page.getContent()){
            if(country.getPrimeMinister().toLowerCase().contains(primeMinister.toLowerCase())){
                countryList.add(country);
            }
        }
        if(countryList.isEmpty()){
            throw new CountryNotFoundException();
        }
        return countryList;
    }
}
