package com.querydemo.querydemo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.querydemo.querydemo.entity.Order;
import com.querydemo.querydemo.entity.User;
import com.querydemo.querydemo.repository.OrderRepo;
import com.querydemo.querydemo.repository.UserRepo;

@Service
public class Orderservice {

    @Autowired
    private UserRepo userepo;

    @Autowired
    private OrderRepo orderepo;

    public Order addOrder(int userId, Order order) {
        User user = userepo.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User ID not found"));

        order.setUser(user);
        return orderepo.save(order);
    }

    public Order updateOrder(int orderId, Order updatedOrder) {
        Order existing = orderepo.findById(orderId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order ID not found"));

        existing.setAmount(updatedOrder.getAmount());

        return orderepo.save(existing);
    }

    public Order getOrderById(int id) {
        return orderepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order ID not found"));
    }

    public List<Order> getAll() {
        return orderepo.findAll();
    }

    public void deleteById(int id) {
        if (!orderepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order ID not found");
        }
        orderepo.deleteById(id);
    }

    public void deleteAll() {
        orderepo.deleteAll();
    }

 // Find orders by user
    public List<Order> getByUser(User user) {
        return orderepo.findByUser(user);
    }

    // Find orders with amount greater than
    public List<Order> getByAmount(Double amount) {
        return orderepo.findByAmountGreaterThan(amount);
    }
    
    public List<Order> getOrderBydesc() {
    	return orderepo.sortOrdersByNamedesc();
    }
    public Double getTotalAmount(int id) {
    	return orderepo.TotalAmountByUserId(id);
    }
    public List<Order> getOrderswithUsers(){
    	return orderepo.getOrdersWithUsers();
    }
    public Double getAvgamount() {
    	return orderepo.averageAmount();
    }
//    pagination
    public Page<Order> getOrders(int page,int size){
    	Pageable pageable=PageRequest.of(page, size);
    	return orderepo.findAll(pageable);
    }
    //  Get orders with users (native)
    public List<Object[]> getOrdersWithUsers() {
        return orderepo.getOrderwithUsersNative();
    }

    // Count total orders
    public Long countOrders() {
        return orderepo.countTotalOrders();
    }

    // Sum of order amounts
    public Long getTotalOrderAmount() {
        return orderepo.sumOfOrders();
    }

    //  Max order amount
    public Long getMaxOrderAmount() {
        return orderepo.MaxAmount();
    }

    //  Total order amount per user
    public List<Object[]> getTotalAmountPerUser() {
        return orderepo.getTotalAmountPerUserNative();
    }

    //  Orders with amount > 1000
    public List<Object[]> getOrdersGreaterThan1000() {
        return orderepo.getOrdersGreaterThan1000();
    }
}
