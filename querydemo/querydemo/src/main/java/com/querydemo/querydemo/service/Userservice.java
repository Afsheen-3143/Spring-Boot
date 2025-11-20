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

	    return repo.save(existing); 
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
	public List<User>getNameByIgnoreCase(String Name){
		return repo.findByNameIgnoreCase(Name);
	}
	 public List<User> searchNameIgnoreCase(String keyword) {
	        return repo.searchNameIgnoreCase(keyword);
	    }
	public List<User>getEmailByIgnoreCase(String mail){
		return repo.findByEmailIgnoreCase(mail);
	}
	public List<User>getRoleByIgnoreCase(String Role){
		return repo.findByRoleIgnoreCase(Role);
	}
	// Sort users by name ASC
    public List<User> sortUsersByNameAsc() {
        return repo.sortUsersByNameAsc();
    }

    // Count total users
    public long countUsers() {
        return repo.countByuser();
    }

    // Fetch user with orders using JOIN FETCH
    public User getUserWithOrders(int id) {
        return repo.getUserwithOrders(id);
    }

    // Get user + order count
    public List<Object[]> getUserOrderCounts() {
        return repo.getUserOrderCounts();
    }

}
