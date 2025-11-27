package com.querydemo.querydemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.querydemo.querydemo.entity.User;

public interface UserRepo extends JpaRepository<User,Integer>{
	
	List<User> findByEmail(String email);

    List<User> findByName(String name);

    List<User> findByRole(String role);
    
    // Case-Insensitive exact name match
    @Query("select u from User u where lower(u.name)=lower(:name)")
    List<User>findByNameIgnoreCase(@Param("name") String name);
 

    // Case-Insensitive contains search (partial)
    @Query("select u from User u where lower(u.name) like lower(concat ('%',:keyword,'%'))")
    List<User>searchNameIgnoreCase(@Param("keyword")String keyword);
      // Case-Insensitive Email Search
    @Query("SELECT u FROM User u WHERE LOWER(u.email) = LOWER(:email)")
    List<User> findByEmailIgnoreCase(@Param("email") String email);

    // Get users by role ignoring case
    @Query("SELECT u FROM User u WHERE LOWER(u.role) = LOWER(:role)")
    List<User> findByRoleIgnoreCase(@Param("role") String role);
    
//    sort users by name ASC
    @Query("select u from User u order by u.name ASC")
    List<User>sortUsersByNameAsc();
    
//    count users
    @Query("select count(u) from User u")
    long countByuser();
    
//    Fetch user with orders (JOIN FETCH)
    @Query("select u from User u JOIN FETCH u.orders where u.id=:id")
    User getUserwithOrders(int id);
    
//    Get User and Order count
    @Query("SELECT u.name, COUNT(o) FROM User u LEFT JOIN u.orders o GROUP BY u.name")
    List<Object[]> getUserOrderCounts();
    
//    Native Query
//    Get orders with user info
    @Query(value = "SELECT u.id AS user_id, u.name, u.role, o.id AS order_id, o.amount FROM user u LEFT JOIN orders o ON u.id = o.user_id",
nativeQuery = true)
List<Object[]> getOrderwithUsers();

//Named Queries
List<User> findByEmailJPQL(String email);

List<User> findByRoleJPQL(String role);

@Query(name = "User.UserswithNoOrders")
List<User>getUserwithNoOrdersJPQL();

@Query(name="User.UserwithOrderCount")
List<Object[]>getUserwithOrderCountJPQL();

@Query(name="User.UserswithOrderCount")
List<User>getUserWithOrderCountJPQL();

@Query(name = "User.nativeUsersWithOrders", nativeQuery = true)
List<User> getUsersWithOrdersNative();

@Query(name = "User.nativeUserswithNoOrders", nativeQuery = true)
List<User> getUsersWithNoOrdersNative();



}


