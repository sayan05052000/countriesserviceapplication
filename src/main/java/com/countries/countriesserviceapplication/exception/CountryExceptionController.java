package com.countries.countriesserviceapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CountryExceptionController {
    
    @ExceptionHandler(value = CountryExistsException.class)
   public ResponseEntity<Object> exception(CountryExistsException exception) {
      return new ResponseEntity<>("Country already exists", HttpStatus.CONFLICT);
   }

   @ExceptionHandler(value = CountryNotFoundException.class)
   public ResponseEntity<Object> exception(CountryNotFoundException exception) {
      return new ResponseEntity<>("Country not found", HttpStatus.NOT_FOUND);
   }
}
