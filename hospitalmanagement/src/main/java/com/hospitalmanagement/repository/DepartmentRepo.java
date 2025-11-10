package com.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.hospitalmanagement.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department,Integer>{

}
