package com.countries.countriesserviceapplication.service;

import org.aspectj.weaver.ast.And;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
        .withUser("Sayan")
        .password("Ishita@29.08.1999")
        .roles("USER").and().withUser("Ishita")
        .password("ishita")
        .roles("ADMIN");
    }
    
    @Bean
    protected PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
        http.authorizeRequests()
        .antMatchers("/countries/addCountry").hasRole("ADMIN")
        .antMatchers("/countries/getCountryByPrimeMinister").hasAnyRole("USER","ADMIN")
        .antMatchers("/countries/getCountryByName").hasAnyRole("USER","ADMIN")
        .antMatchers("/countries/home","/countries/").permitAll()
        .and().formLogin();
    }
    
}
