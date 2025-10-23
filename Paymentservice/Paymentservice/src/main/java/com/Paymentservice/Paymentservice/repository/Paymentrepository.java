package com.Paymentservice.Paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Paymentservice.Paymentservice.Model.Payment;

@Repository
public interface Paymentrepository extends JpaRepository<Payment,Integer>{

}
