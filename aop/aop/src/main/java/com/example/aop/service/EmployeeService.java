package com.example.aop.service;

import org.springframework.stereotype.Service;

import com.example.aop.entity.Employee;

@Service
public class EmployeeService {
	public Employee createEmp(String empId, String firstName, String secondName) {
		Employee emp=new Employee();
		emp.setEmpId(empId);
		emp.setFirstName(firstName);
		emp.setSecondName(secondName);
		return emp;
	}

}
