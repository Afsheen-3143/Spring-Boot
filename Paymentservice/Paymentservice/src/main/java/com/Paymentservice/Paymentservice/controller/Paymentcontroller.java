package com.Paymentservice.Paymentservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Paymentservice.Paymentservice.Model.Payment;
import com.Paymentservice.Paymentservice.service.Paymentservice;


@RestController
@RequestMapping("/payment")
public class Paymentcontroller {

    @Autowired
    private Paymentservice service;

    // Add new payment
    @PostMapping("/add")
    public ResponseEntity<Payment> addPayment(@RequestBody Payment p) {
        Payment pay = service.addpayments(p);
        return ResponseEntity.ok(pay);
    }

    // Get all payments
    @GetMapping("/all")
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = service.getallpayments();
        return ResponseEntity.ok(payments);
    }

    // Get payment by ID
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable int id) {
        Payment p = service.getpaymentbyid(id);
        if (p == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(p);
    }

    // Update payment
    @PutMapping("/update/{id}")
    public ResponseEntity<Payment> updateById(@PathVariable int id, @RequestBody Payment p) {
        Payment pay = service.updatebyid(id, p);
        if (pay == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pay);
    }

    // Delete by ID
    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        String result = service.deletebyid(id);
        return ResponseEntity.ok(result);
    }

    // Delete all payments
    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteAll() {
        String result = service.deleteall();
        return ResponseEntity.ok(result);
    }
}
