package com.transactionsystem.transactionsystem.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transactionsystem.transactionsystem.entity.Account;
import com.transactionsystem.transactionsystem.entity.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction,Long>{

	    
	}


