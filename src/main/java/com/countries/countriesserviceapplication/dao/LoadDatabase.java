package com.countries.countriesserviceapplication.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.countries.countriesserviceapplication.model.Country;
import com.countries.countriesserviceapplication.repository.CountryRepository;
@Component
class LoadDatabase {
  
    @Bean
    public CountryRepository initDatabase(CountryRepository countryRepository) {
      countryRepository.save(new Country(1,"India","Narendra Modi"));
      countryRepository.save(new Country(2,"China"," Li Keqiang"));
      countryRepository.save(new Country(3,"Kazakhstan","Alikhan Smailov"));
      countryRepository.save(new Country(4,"Saudi Arabia","Mohammed bin Salman"));
      countryRepository.save(new Country(5,"Iran","Ebrahim Raisi"));
      countryRepository.save(new Country(6,"Mongolia","Luvsannamsrain Oyun-Erdene"));
      countryRepository.save(new Country(7,"Indonesia","Joko Widodo"));
      countryRepository.save(new Country(8,"Pakistan ","Shehbaz Sharif"));
      countryRepository.save(new Country(9,"Turkey","Recep Tayyip Erdogan"));
      countryRepository.save(new Country(10,"Myanmar ","Myint Swe"));
      countryRepository.save(new Country(11,"Afghanistan","Mohammad Hassan Akhund"));
      countryRepository.save(new Country(12,"Yemen","Maeen Abdulmalik Saeed"));
      countryRepository.save(new Country(13,"Thailand","Prayut Chan-o-cha"));
      countryRepository.save(new Country(14,"Turkmenistan","Gurbanguly Berdimuhamedow"));
      countryRepository.save(new Country(15,"Uzbekistan","Abdulla Aripov"));
      countryRepository.save(new Country(16,"Iraq","Mustafa Al-Kadhimi"));
      countryRepository.save(new Country(17,"Japan","Fumio Kishida"));
      countryRepository.save(new Country(18,"Vietnam","Pham Minh Chinh"));
      countryRepository.save(new Country(19,"Malaysia","Muhyiddin Yassin"));
      countryRepository.save(new Country(20,"Oman","Haitham bin Tarik"));
      countryRepository.save(new Country(21,"Philippines","Rodrigo Duterte"));
      countryRepository.save(new Country(22,"Laos","Phankham Viphavanh"));
      countryRepository.save(new Country(23,"Kyrgyzstan","Ulukbek Maripov"));
      countryRepository.save(new Country(24,"Syria","Hussein Arnous"));
      countryRepository.save(new Country(25,"Cambodia","Hun Sen"));
      countryRepository.save(new Country(26,"Bangladesh","Sheikh Hasina"));
      countryRepository.save(new Country(27,"Nepal","K. P. Sharma Oli"));
      countryRepository.save(new Country(28,"Tajikistan","Kokhir Rasulzoda"));
      return countryRepository;
    }
    
  }