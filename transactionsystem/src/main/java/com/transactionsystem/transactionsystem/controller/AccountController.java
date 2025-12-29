package com.transactionsystem.transactionsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.transactionsystem.transactionsystem.entity.Account;
import com.transactionsystem.transactionsystem.service.Accountservice;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private Accountservice service;
	@PostMapping("/add")
	public Account addaccount(@RequestBody Account account) {
		return service.addaccount(account);
	}
	@GetMapping("/getall")
	public List<Account> getaccount() {
	return service.getaccount();

}}
