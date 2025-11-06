package com.deptemp.deptemp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.deptemp.deptemp.Entity.Department;
import com.deptemp.deptemp.Entity.Employee;
import com.deptemp.deptemp.repository.DepartmentRepo;
import com.deptemp.deptemp.repository.EmployeeRepo;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    // Add Employee
    public Employee addEmployee(Employee employee) {
        try {
            int deptId = employee.getDepartment().getDeptId();
            Department department = departmentRepo.findById(deptId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found"));
            employee.setDepartment(department);
            return employeeRepo.save(employee);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Department ID");
        }
    }

    // Get all Employees
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    // Get Employee by ID
    public Employee getEmployeeById(int id) {
        return employeeRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee ID not found"));
    }

    // Update Employee by ID
    public Employee updateEmployee(int id, Employee updatedEmployee) {
        Employee existingEmployee = employeeRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee ID not found"));

        existingEmployee.setEmpName(updatedEmployee.getEmpName());
        existingEmployee.setDepartment(updatedEmployee.getDepartment());

        return employeeRepo.save(existingEmployee);
    }

    // Delete Employee by ID
    public void deleteById(int id) {
        if (!employeeRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
        employeeRepo.deleteById(id);
        System.out.println("Employee deleted successfully");
    }

    // Delete all Employees
    public void deleteAll() {
        employeeRepo.deleteAll();
        System.out.println("All employees deleted successfully");
    }
}
