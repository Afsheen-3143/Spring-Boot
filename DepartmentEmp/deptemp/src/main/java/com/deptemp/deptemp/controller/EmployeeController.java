package com.deptemp.deptemp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deptemp.deptemp.Entity.Employee;
import com.deptemp.deptemp.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
	private EmployeeService empser;
	
	@PostMapping("/add")
	public Employee addemps(@RequestBody Employee e) {
		return empser.addEmployee(e);
	}
	@PutMapping("/update/{id}")
	public Employee updateemp(@PathVariable int id,@RequestBody Employee e) {
		return empser.updateEmployee(id, e);
	}
	@GetMapping("/getall")
	public List<Employee> getallemp() {
		return empser.getAllEmployees();
	}
	@GetMapping("/getbyid/{id}")
	public Employee getbyid(@PathVariable int id) {
		return empser.getEmployeeById(id);
	}
	@DeleteMapping("deletebyid/{id}")
	public void deletebyid(@PathVariable int id) {
		empser.deleteById(id);
		return ;
	}
	@DeleteMapping("deleteall")
	public void deleteall() {
		empser.deleteAll();
	}

}
