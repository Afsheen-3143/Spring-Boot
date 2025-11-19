package com.querydemo.querydemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.querydemo.querydemo.entity.User;

public interface UserRepo extends JpaRepository<User,Integer>{
	
	List<User> findByEmail(String email);

    List<User> findByName(String name);

    List<User> findByRole(String role);

}
