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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.deptemp.deptemp.Entity.Department;
import com.deptemp.deptemp.service.DepartmentService;





@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentser;
	
	@PostMapping("/add")
	public Department adddept(@RequestBody Department department) {
		return departmentser.addDept(department);
	}
	@GetMapping("/getall")
	public List<Department> getdept() {
		return departmentser.getAllDepts();
	}
	@GetMapping("/getbyid/{deptId}")
	public Department getbyId(@PathVariable int deptId) {
		return departmentser.getById(deptId);
	}
	@PutMapping("/update/{deptId}")
	public Department updatebyId(@PathVariable int deptId,@RequestBody Department department) {
		return departmentser.updateDepartment(deptId, department);
	}
	@DeleteMapping("/delete/{deptId}")
	public void deletebyid(@PathVariable int deptId) {
		departmentser.deleteDepartment(deptId);
		return; 
	}

}
