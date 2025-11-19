package com.querydemo.querydemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}
