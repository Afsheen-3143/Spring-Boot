package com.querydemo.querydemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.querydemo.querydemo.entity.Order;
import com.querydemo.querydemo.entity.User;

public interface OrderRepo extends JpaRepository<Order,Integer>{
	List<Order>findByUser(User user);
	List<Order>findByAmountGreaterThan(Double amount);
	
//	sort order by desc
	@Query("select o from Order o order by o.amount desc")
	List<Order>sortOrdersByNamedesc();
	
//	count amount
	@Query("select sum(o.amount) from Order o where o.user.id = :userId")
	Double TotalAmountByUserId(@Param("userId") int userId);

//	avg amount
	@Query("select avg(o.amount) from Order o")
	Double averageAmount();
	
	@Query("SELECT o FROM Order o JOIN FETCH o.user u")
	List<Order> getOrdersWithUsers();


}
