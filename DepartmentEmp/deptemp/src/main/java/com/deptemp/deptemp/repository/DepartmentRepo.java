package com.deptemp.deptemp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deptemp.deptemp.Entity.Department;

public interface DepartmentRepo extends JpaRepository<Department,Integer>{

}
