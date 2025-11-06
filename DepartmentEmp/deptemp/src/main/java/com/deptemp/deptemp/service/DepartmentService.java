package com.deptemp.deptemp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.deptemp.deptemp.Entity.Department;
import com.deptemp.deptemp.repository.DepartmentRepo;


@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepository;

    // Add department
    public Department addDept(Department department) {
        if (department.getDeptName() == null || department.getDeptName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Department name should not be empty");
        }
        return departmentRepository.save(department);
    }

    // Get all departments
    public List<Department> getAllDepts() {
        return departmentRepository.findAll();
    }

    // Get department by ID
    public Department getById(int deptId) {
        return departmentRepository.findById(deptId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found"));
    }

    // Update department
    public Department updateDepartment(int id, Department updatedDept) {
        Department existingDept = departmentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found"));
        existingDept.setDeptName(updatedDept.getDeptName());
        return departmentRepository.save(existingDept);
    }

    // Delete department by ID
    public void deleteDepartment(int id) {
        if (!departmentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found");
        }
        departmentRepository.deleteById(id);
    }
}
