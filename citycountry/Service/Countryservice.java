package com.citycountry.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.citycountry.Entity.Country;
import com.citycountry.Repository.CountryRepo;


@Service
public class Countryservice {
@Autowired
private CountryRepo countryrepo;

public List<Country> getcountries(){
	return countryrepo.findAll();
}

public Country getbyid(int id) {
	try
	{
	Country country= countryrepo.findById(id).get();
	return country;
	}catch(Exception e) {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND) ;
	}
}

public Country addcountries(Country c) {
	return countryrepo.save(c);
}
public Country updatecountry(int id,Country newcountry) {
	try {
		Country existingcountry=countryrepo.findById(id).get();
		existingcountry.setCountryname(newcountry.getCountryname());
		countryrepo.save(existingcountry);
		return existingcountry;
	} catch (Exception e) {
		// TODO Auto-generated catch block
	throw new ResponseStatusException(HttpStatus.NOT_FOUND) ;
	}
	}
public void deletebyid(int id) {
	countryrepo.deleteById(id);
	System.out.println("deleted successfully");
}




}


