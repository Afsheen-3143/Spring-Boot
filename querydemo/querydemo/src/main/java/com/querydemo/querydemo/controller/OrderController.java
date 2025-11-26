package com.querydemo.querydemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.querydemo.querydemo.entity.Order;
import com.querydemo.querydemo.entity.User;
import com.querydemo.querydemo.service.Orderservice;
import com.querydemo.querydemo.service.Userservice;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private Orderservice orderservice;

    @Autowired
    private Userservice userservice;

    @PostMapping("/add/{userId}")
    public ResponseEntity<Order> addOrder(@PathVariable int userId, @RequestBody Order order) {
        return ResponseEntity.ok(orderservice.addOrder(userId, order));
    }

    @PutMapping("/update/{orderId}")
    public ResponseEntity<Order> updateOrder(
            @PathVariable int orderId,
            @RequestBody Order updatedOrder) {

        return ResponseEntity.ok(orderservice.updateOrder(orderId, updatedOrder));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) {
        return ResponseEntity.ok(orderservice.getOrderById(id));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderservice.getAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrderById(@PathVariable int id) {
        orderservice.deleteById(id);
        return ResponseEntity.ok("Order deleted successfully");
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll() {
        orderservice.deleteAll();
        return ResponseEntity.ok("All orders deleted successfully");
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUser(@PathVariable int userId) {

        User user = userservice.getById(userId);  // fetch full user object
        return ResponseEntity.ok(orderservice.getByUser(user));
    }

    @GetMapping("/amount/{amount}")
    public ResponseEntity<List<Order>> getOrdersByAmount(@PathVariable Double amount) {
        return ResponseEntity.ok(orderservice.getByAmount(amount));
    }
    
    @GetMapping("/sort")
    public ResponseEntity<List<Order>> getSortedOrdersByAmountDesc(){
    	return ResponseEntity.ok(orderservice.getOrderBydesc());
    }
    
    @GetMapping("/total/{userId}")
    public Double getTotalAmount(@PathVariable int userId) {
        return orderservice.getTotalAmount(userId);
    }
    
    @GetMapping("/orderwithusers")
    public ResponseEntity<List<Order>>getOrderwithUser(){
    	return ResponseEntity.ok(orderservice.getOrderswithUsers());
    }
    
    @GetMapping("/avgamount")
    public ResponseEntity<Double>getAvgamount(){
    	return ResponseEntity.ok(orderservice.getAvgamount());
    }
    
    @GetMapping("/page")
    public ResponseEntity<Page<Order>> getPages(
            @RequestParam int page,
            @RequestParam int size) {

        return ResponseEntity.ok(orderservice.getOrders(page, size));
    }
    //  Orders with User Details (native join)
    @GetMapping("/with-users")
    public ResponseEntity<List<Object[]>> getOrdersWithUsers() {
        return ResponseEntity.ok(orderservice.getOrdersWithUsers());
    }

    //  Count Orders
    @GetMapping("/count")
    public ResponseEntity<Long> countOrders() {
        return ResponseEntity.ok(orderservice.countOrders());
    }

    //  Sum of Order Amounts
    @GetMapping("/sum")
    public ResponseEntity<Long> getTotalOrderAmount() {
        return ResponseEntity.ok(orderservice.getTotalOrderAmount());
    }

    //  Max Order Amount
    @GetMapping("/max")
    public ResponseEntity<Long> getMaxOrderAmount() {
        return ResponseEntity.ok(orderservice.getMaxOrderAmount());
    }

    //  Total amount per user
    @GetMapping("/total-per-user")
    public ResponseEntity<List<Object[]>> getTotalAmountPerUser() {
        return ResponseEntity.ok(orderservice.getTotalAmountPerUser());
    }

    //  Orders > 1000
    @GetMapping("/greater-1000")
    public ResponseEntity<List<Object[]>> getOrdersGreaterThan1000() {
        return ResponseEntity.ok(orderservice.getOrdersGreaterThan1000());
    }
    }

