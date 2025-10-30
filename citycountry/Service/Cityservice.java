package com.citycountry.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citycountry.Entity.City;
import com.citycountry.Entity.Country;
import com.citycountry.Repository.CityRepo;
import com.citycountry.Repository.CountryRepo;

@Service
public class Cityservice {

	@Autowired
	private CityRepo cityrepo;
	@Autowired
	private CountryRepo countryrepo;
	
//	get all cities
	public List<City> getall() {
		return cityrepo.findAll();
		
	}
//	add city
	public City addcities(int countryid,City city) {
		Country country=countryrepo.findById(countryid).orElseThrow( ()->new RuntimeException("country not found"+countryid));
		city.setCountry(country);
		return cityrepo.save(city);
	}
//	update city
	public City updatecity(int cityid,City updatedcity) {
		City city=cityrepo.findById(cityid).orElseThrow(()->new RuntimeException("city not found"+cityid));
		city.setCityname(updatedcity.getCityname());
		if (updatedcity.getCountry() != null && updatedcity.getCountry().getCountryid() != 0) {
	        int countryId = updatedcity.getCountry().getCountryid();
	        Country existingCountry = countryrepo.findById(countryId)
	                .orElseThrow(() -> new RuntimeException("Country not found with ID: " + countryId));
	        city.setCountry(existingCountry);
	    }

	    return cityrepo.save(city);
	}
	
//	deleteall
	public void deleteCity(int cityId) {
        cityrepo.deleteById(cityId);
    }

}
