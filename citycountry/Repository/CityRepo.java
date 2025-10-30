package com.citycountry.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citycountry.Entity.City;

public interface CityRepo extends JpaRepository<City,Integer>{

}
