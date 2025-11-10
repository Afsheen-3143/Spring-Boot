package com.hospitalmanagement.controller;

import com.hospitalmanagement.entity.Department;
import com.hospitalmanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/departments")
@CrossOrigin(origins = "*")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    //  Add Department
    @PostMapping("/aaaaa")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        return ResponseEntity.ok(departmentService.addDepartment(department));
    }

    //  Get All Departments
    @GetMapping
    public ResponseEntity<List<Department>> getAll() {
        return ResponseEntity.ok(departmentService.getAll());
    }

    //  Get Department by ID
    @GetMapping("/{id}")
    public ResponseEntity<Department> getById(@PathVariable int id) {
        return ResponseEntity.ok(departmentService.getById(id));
    }

    //  Update Department
    @PutMapping("/{id}")
    public ResponseEntity<Department> update(@PathVariable int id, @RequestBody Department department) {
        return ResponseEntity.ok(departmentService.updateDepartment(id, department));
    }

    //  Delete Department by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        departmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //  Delete All Departments
    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        departmentService.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
