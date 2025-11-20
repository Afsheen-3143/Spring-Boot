package com.querydemo.querydemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.querydemo.querydemo.entity.User;
import com.querydemo.querydemo.service.Userservice;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private Userservice service;

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<>(service.addUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        return new ResponseEntity<>(service.updateUser(id, updatedUser), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable int id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        service.deleteById(id);
        return new ResponseEntity<>("User deleted successfully!", HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll() {
        service.deleteAll();
        return new ResponseEntity<>("All users deleted successfully!", HttpStatus.OK);
    }

 

    // Find By Email
    @GetMapping("/email/{email}")
    public ResponseEntity<List<User>> findByEmail(@PathVariable String email) {
        return new ResponseEntity<>(service.getByemail(email), HttpStatus.OK);
    }

    // Find By Name
    @GetMapping("/name/{name}")
    public ResponseEntity<List<User>> findByName(@PathVariable String name) {
        return new ResponseEntity<>(service.getByname(name), HttpStatus.OK);
    }

    // Find By Role
    @GetMapping("/role/{role}")
    public ResponseEntity<List<User>> findByRole(@PathVariable String role) {
        return new ResponseEntity<>(service.getByrole(role), HttpStatus.OK);
    }
    
    @GetMapping("/namelower/{name}")
    public ResponseEntity<List<User>> findByNameIgnoranceCase(@PathVariable String name){
    	return new ResponseEntity<>(service.getNameByIgnoreCase(name),HttpStatus.OK);
    }
    @GetMapping("/search/{keyword}")
    public List<User> searchNameIgnoreCase(@PathVariable String keyword) {
        return service.searchNameIgnoreCase(keyword);
    }
    @GetMapping("/emaillower/{email}")
    public ResponseEntity<List<User>> findByEmailIgnoranceCase(@PathVariable String email){
    	return new ResponseEntity<>(service.getEmailByIgnoreCase(email),HttpStatus.OK);
    }
    @GetMapping("/rolelower/{role}")
    public ResponseEntity<List<User>> findByRoleIgnoranceCase(@PathVariable String role){
    	return new ResponseEntity<>(service.getRoleByIgnoreCase(role),HttpStatus.OK);
    }
   
    @GetMapping("/sort/name")
    public ResponseEntity<List<User>> sortUsersByNameAsc() {
        return ResponseEntity.ok(service.sortUsersByNameAsc());
    }

    // Count total users
    @GetMapping("/count")
    public ResponseEntity<Long> countUsers() {
        return ResponseEntity.ok(service.countUsers());
    }

    // Fetch user with orders
    @GetMapping("/with-orders/{id}")
    public ResponseEntity<User> getUserWithOrders(@PathVariable int id) {
        return ResponseEntity.ok(service.getUserWithOrders(id));
    }

    // Get user with order counts
    @GetMapping("/order-counts")
    public ResponseEntity<List<Object[]>> getUserOrderCounts() {
        return ResponseEntity.ok(service.getUserOrderCounts());
    }
}
