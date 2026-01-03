package com.example.aop.service;

import org.springframework.stereotype.Service;
import com.example.aop.entity.Employee;

@Service
public class EmployeeService {

    public Employee createEmp(String empId, String firstName, String secondName) {

        if ("0".equals(empId)) {
            throw new RuntimeException("Invalid employee id");
        }

        Employee emp = new Employee();
        emp.setEmpId(empId);
        emp.setFirstName(firstName);
        emp.setSecondName(secondName);

        System.out.println("Employee created inside service");

        return emp;
    }

    public void deleteEmployee(String empId) {

        if ("0".equals(empId)) {
            throw new RuntimeException("Employee not found");
        }

        System.out.println("Employee deleted inside service");
    }
}
