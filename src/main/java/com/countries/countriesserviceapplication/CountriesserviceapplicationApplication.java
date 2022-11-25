package com.countries.countriesserviceapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CountriesserviceapplicationApplication extends SpringBootServletInitializer {
	
	// @Bean
	// public CountryRepository countryRepository(){
	// 	return new CountryRepository();
	// }
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CountriesserviceapplicationApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(CountriesserviceapplicationApplication.class, args);
	}

}
