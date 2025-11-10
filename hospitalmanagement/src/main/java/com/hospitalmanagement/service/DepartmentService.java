package com.hospitalmanagement.service;

import com.hospitalmanagement.entity.Department;
import com.hospitalmanagement.entity.Doctor;
import com.hospitalmanagement.repository.DepartmentRepo;
import com.hospitalmanagement.repository.DoctorRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    // Add Department (Many-to-One: Each Department belongs to one Doctor)
    public Department addDepartment(Department department) {
        if (department.getDeptName() == null || department.getDeptName().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Department name cannot be empty");
        }

        // Check if department is linked to a valid doctor
        if (department.getDoctor() != null) {
            int doctorId = department.getDoctor().getDoctorId();

            Doctor doctor = doctorRepo.findById(doctorId)
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Doctor not found with ID: " + doctorId));

            department.setDoctor(doctor); // Link department to existing doctor
        }

        return departmentRepo.save(department);
    }

    // Get all departments
    public List<Department> getAll() {
        return departmentRepo.findAll();
    }

    // Get department by ID
    public Department getById(int id) {
        return departmentRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found"));
    }

    //  Update Department details (name & linked doctor)
    public Department updateDepartment(int id, Department updatedDepartment) {
        Department existing = getById(id);

        // Update department name
        if (updatedDepartment.getDeptName() != null && !updatedDepartment.getDeptName().trim().isEmpty()) {
            existing.setDeptName(updatedDepartment.getDeptName());
        }

        //  Update linked doctor (Many-to-One)
        if (updatedDepartment.getDoctor() != null) {
            int doctorId = updatedDepartment.getDoctor().getDoctorId();
            Doctor doctor = doctorRepo.findById(doctorId)
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Doctor not found with ID: " + doctorId));
            existing.setDoctor(doctor);
        }

        return departmentRepo.save(existing);
    }

    //  Delete Department by ID
    public void deleteById(int id) {
        if (!departmentRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department ID not found");
        }
        departmentRepo.deleteById(id);
    }

    //  Delete all departments
    public void deleteAll() {
        departmentRepo.deleteAll();
    }
}
