package com.querydemo.querydemo.entity;

import java.util.ArrayList;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@NamedQueries({
	//find user by email
	 @NamedQuery(
		        name = "User.findByEmailJPQL",
		        query = "SELECT u FROM User u WHERE u.email = :email"
		    ),
//	 get user by role
	 @NamedQuery(
			 name="User.findByRoleJPQL",
			 query="select u from User u where u.role=:role"),
	 // 4. Get users with NO orders
	 @NamedQuery(
			 name="User.UserswithNoOrders",
			 query="select u from User u where u.orders IS Empty"),
//	   // 5. Get user order count
	 @NamedQuery(
			 name="User.UserwithOrderCount",
			 query="select u.name, count(o) from User u Left Join u.orders o group by u.name")
})
@NamedNativeQueries({
	// 1. Get users with their order count in Native
	 @NamedNativeQuery(
			 name="User.UserswithOrderCount",
			 query="select u.id, u.name, count(o.id) from User u Left Join orders o ON u.id=o.user_id group by u.names",
			 resultClass = User.class),
//	 Get users who have placed orders
	 @NamedNativeQuery(
			 name="User.nativeUsersWithOrders",
			 query="select distinct u.* from User u inner join orders o ON u.id=o.user_id",
	         resultClass = User.class),
//	 get users with no orders
	 @NamedNativeQuery(
			 name="User.nativeUserswithNoOrders",
			 query="SELECT * FROM User WHERE id NOT IN (SELECT user_id FROM orders)",
			 resultClass = User.class)
})

@Entity
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Order> orders = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
    
}
