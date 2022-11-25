package com.countries.countriesserviceapplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.countries.countriesserviceapplication.model.Country;
import com.countries.countriesserviceapplication.service.CountryService;

@RestController
@RequestMapping("/countries")
public class CountryController{
    @Autowired
    CountryService countryService;
    List<Country> list=new ArrayList<>();

    @RequestMapping({"/","/home"})
    List<Country> loadAllCountries(){
        return countryService.loadInitializeData();
    }

    @RequestMapping("/home/{pageNo}/{pageSize}")
    List<Country> loadCountries(@PathVariable(name="pageNo") int pageNo,@PathVariable("pageSize") int pageSize){
        return countryService.loadData(pageNo, pageSize);
    }
    
    @RequestMapping("/addCountry")
    ResponseEntity<Object> addCountries(@RequestParam(name="countryName",required = true)String countryName,@RequestParam(name="primeMinister",required=true,defaultValue = "null")String primeMinister){
        return countryService.addData(countryName, primeMinister);
    }
    
    @RequestMapping("/getCountryByName")
    List<Country> getUserCountryByName(@RequestParam(name="pageNo",defaultValue="0") int pageNo,@RequestParam(name="pageSize",defaultValue="10") int pageSize,@RequestParam(name="countryName",defaultValue = "") String countryName){
        return countryService.findPaginatedByCountryName(pageNo,pageSize, countryName);
        
    }

    @RequestMapping("/getCountryByPrimeMinister")
    List<Country> getUserCountryByPrimeMinister(@RequestParam(name="pageNo",defaultValue="0") int pageNo,@RequestParam(name="pageSize",defaultValue="10") int pageSize,@RequestParam(name="primeMinister",defaultValue = "") String primeMinister){
        return countryService.findPaginatedByPrimeMinister(pageNo,pageSize, primeMinister);

        
    }
}
