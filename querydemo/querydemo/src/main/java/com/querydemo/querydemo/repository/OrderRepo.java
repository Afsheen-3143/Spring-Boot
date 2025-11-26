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
	
	@Query(value = "SELECT o.id AS order_id, o.amount, u.role, u.name, u.id AS user_id " +
            "FROM orders o " +
            "LEFT JOIN user u ON u.id = o.user_id",
    nativeQuery = true)
List<Object[]> getUserwithOrders();

//get orders withusers using native
@Query(value="select o.id, o.amount, u.name, u.role, u.email from orders o Inner Join user u on u.id=o.user_id", nativeQuery = true)
List<Object[]>getOrderwithUsersNative();

//count orders
@Query(value="select count(*) from orders", nativeQuery = true)
Long countTotalOrders();

//sum of amount
@Query(value="select sum(amount) from orders o",nativeQuery = true)
Long sumOfOrders();

@Query("select max(o.amount) from Order o")
Long MaxAmount();

//Total order amount per user
@Query(value = "SELECT user_id, SUM(amount) FROM orders GROUP BY user_id",
nativeQuery = true)
List<Object[]> getTotalAmountPerUserNative();


@Query(value = "SELECT user_id, amount FROM orders WHERE amount > 1000",
nativeQuery = true)
List<Object[]> getOrdersGreaterThan1000();

}
