package com.querydemo.querydemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.querydemo.querydemo.entity.User;
import com.querydemo.querydemo.repository.UserRepo;

@Service
public class Userservice {
	@Autowired
	private UserRepo repo;
	
	public User addUser(User user) {
		return repo.save(user);
		
	}
	public User updateUser(int id, User updated) {
	    User existing = repo.findById(id)
	            .orElseThrow(() -> new RuntimeException("user not found"));

	    existing.setName(updated.getName());
	    existing.setEmail(updated.getEmail());
	    existing.setRole(updated.getRole());

	    // If you're allowing updating orders, do it correctly:
	    if (updated.getOrders() != null) {
	        existing.getOrders().clear();
	        existing.getOrders().addAll(updated.getOrders());
	    }

	    return repo.save(existing);  // IMPORTANT: save existing, not updated!
	}

	public User getById(int id) {
		return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "not found with the Id"));
	}
	public List<User> getAll() {
		return repo.findAll();
	}
	public void deleteById(int id) {
		if(!repo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, " ID not found");
        }
		repo.deleteById(id);
		}
	public void deleteAll() {
		repo.deleteAll();
	}
	public List<User> getByemail(String email) {
		return repo.findByEmail(email);
	}
	public List<User> getByname(String name) {
		return repo.findByName(name); 
	}
	public List<User> getByrole(String role) {
		return repo.findByRole(role);
	}
}
