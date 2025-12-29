package com.transactionsystem.transactionsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transactionsystem.transactionsystem.entity.Account;
import com.transactionsystem.transactionsystem.repository.AccountRepo;

@Service
public class Accountservice {
	
	@Autowired
	private AccountRepo repo;
	
	public Account addaccount(Account account) {
		return repo.save(account);
	}
	public List<Account> getaccount() {
		return repo.findAll();
	}

}
