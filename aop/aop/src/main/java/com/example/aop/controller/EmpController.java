package com.example.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.aop.entity.Employee;
import com.example.aop.service.EmployeeService;


@RestController
@RequestMapping("/employee")

public class EmpController {
	@Autowired  
	private EmployeeService employeeService; 


	    @PostMapping("/create")
	    public String createEmployee(
	            @RequestParam String empId,
	            @RequestParam String fname,
	            @RequestParam String sname) {

	        employeeService.createEmp(empId, fname, sname);
	        return "Employee create request processed";
	    }

	    @DeleteMapping("/delete/{id}")
	    public String deleteEmployee(@PathVariable("id") String id) {
	        employeeService.deleteEmployee(id);
	        return "Employee delete request processed";
	    }
	
}
