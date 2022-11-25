package com.countries.countriesserviceapplication.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    long id;
    @Column(name="countryName")
    String countryName;
    @Column(name = "primeMinister")
    String primeMinister;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public String getPrimeMinister() {
        return primeMinister;
    }
    public void setPrimeMinister(String primeMinister) {
        this.primeMinister = primeMinister;
    }
    public Country() {
        
    }
    public Country(long id, String countryName, String primeMinister) {
        this.id = id;
        this.countryName = countryName;
        this.primeMinister = primeMinister;
    }
    public Country(String string, String string2) {
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return primeMinister == country.primeMinister &&
                Objects.equals(id, country.id) &&
                Objects.equals(countryName, country.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countryName, primeMinister);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Country{");
        sb.append("id=").append(id);
        sb.append(", name='").append(countryName).append('\'');
        sb.append(", population=").append(primeMinister);
        sb.append('}');
        return sb.toString();
    }
}
