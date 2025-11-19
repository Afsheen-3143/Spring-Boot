package com.querydemo.querydemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.querydemo.querydemo.entity.Order;
import com.querydemo.querydemo.entity.User;

public interface OrderRepo extends JpaRepository<Order,Integer>{
	List<Order>findByUser(User user);
	List<Order>findByAmountGreaterThan(Double amount);

}
