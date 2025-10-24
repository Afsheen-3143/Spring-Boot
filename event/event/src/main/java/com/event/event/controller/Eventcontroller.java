package com.event.event.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.event.event.Model.Evententity;
import com.event.event.service.Eventservice;

@RestController
@RequestMapping("/event")
public class Eventcontroller {
	@Autowired
	private Eventservice ser;
	
	@PostMapping("/")
	public ResponseEntity<Evententity> addevent(@RequestBody Evententity e) {
		Evententity event=ser.addevent(e);
		return ResponseEntity.ok(event);
	}
	@GetMapping("/")
	public ResponseEntity<List<Evententity>> getallevents(){
		List<Evententity> event=ser.getallevents();
		return ResponseEntity.ok(event);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Evententity> getbyid(@PathVariable int id) {
	    Optional<Evententity> event = ser.geteventbyid(id);
	    
	    if (event.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    }

	    return ResponseEntity.ok(event.get());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Evententity> updatebyid(@PathVariable int id, @RequestBody Evententity e) {
	    Evententity event = ser.updateevent(id, e);
	    if (event == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok(event);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Evententity> updatepartialbyid(@PathVariable int id, @RequestBody Evententity e) {
	    Evententity event = ser.updatepartially(id, e);
	    if (event == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok(event);
	}

     @DeleteMapping("/{id}")
     public ResponseEntity<String>deletebyid(@PathVariable int id){
    		String event=ser.deletebyid(id);
    		
    			return ResponseEntity.ok(event);

     }
     @DeleteMapping("/")
     public ResponseEntity<String>deleteall(){
    	 String event=ser.deleteall();
    	 return ResponseEntity.ok(event);
     }
}