package com.citycountry.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.citycountry.Entity.City;
import com.citycountry.Service.Cityservice;

@RestController
@RequestMapping("/city")
public class Citycontroller {

    @Autowired
    private Cityservice cityservice;

    // Add city and link it to a specific country
    @PostMapping("/addcity/{countryid}")
    public City addcity(@PathVariable int countryid, @RequestBody City city) {
        return cityservice.addcities(countryid, city);
    }

    // Get all cities
    @GetMapping("/getall")
    public List<City> getAllCities() {
        return cityservice.getall();
    }
    
//    update city
    @PutMapping("/updatecity/{cityid}")
    public City updatecity(@PathVariable int cityid, @RequestBody City city) {
    	return cityservice.updatecity(cityid, city);
    }
//    deleteall
    @DeleteMapping("/delete/{cityid}")
    public void deletecity(@PathVariable int cityid) {
    	 cityservice.deleteCity(cityid);
    }
}
