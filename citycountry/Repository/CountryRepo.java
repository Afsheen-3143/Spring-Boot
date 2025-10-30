package com.citycountry.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.citycountry.Entity.Country;

public interface CountryRepo extends JpaRepository<Country,Integer> {

}
