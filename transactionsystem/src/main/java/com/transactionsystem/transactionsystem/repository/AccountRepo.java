package com.transactionsystem.transactionsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transactionsystem.transactionsystem.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Long> {

}
	
	


