package com.deptemp.deptemp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deptemp.deptemp.Entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer>{

}
