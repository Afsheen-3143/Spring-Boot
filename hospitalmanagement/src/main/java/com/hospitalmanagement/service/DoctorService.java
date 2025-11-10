package com.hospitalmanagement.service;

import com.hospitalmanagement.entity.Department;
import com.hospitalmanagement.entity.Doctor;
import com.hospitalmanagement.entity.Patient;
import com.hospitalmanagement.repository.DepartmentRepo;
import com.hospitalmanagement.repository.DoctorRepo;
import com.hospitalmanagement.repository.PatientRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private PatientRepo patientRepo;

    // Add Doctor (One-to-Many + Many-to-Many)
    public Doctor addDoctor(Doctor doctor) {
        if (doctor.getDoctorName() == null || doctor.getDoctorName().trim().isEmpty()
                || doctor.getSpecialization() == null || doctor.getSpecialization().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Doctor name and specialization must not be empty");
        }

        // One-to-Many: set doctor reference inside each department
        if (doctor.getDepartments() != null && !doctor.getDepartments().isEmpty()) {
            for (Department dept : doctor.getDepartments()) {
                dept.setDoctor(doctor); // link department → doctor
            }
        }

        // Many-to-Many: validate patients if provided
        if (doctor.getPatients() != null && !doctor.getPatients().isEmpty()) {
            List<Patient> patients = doctor.getPatients().stream()
                    .map(p -> patientRepo.findById(p.getPatientId())
                            .orElseThrow(() -> new ResponseStatusException(
                                    HttpStatus.NOT_FOUND, "Patient not found with ID: " + p.getPatientId())))
                    .collect(Collectors.toList());
            doctor.setPatients(patients);
        }

        return doctorRepo.save(doctor);
    }

    // Get all doctors
    public List<Doctor> getAll() {
        return doctorRepo.findAll();
    }

    // Get doctor by ID
    public Doctor getById(int id) {
        return doctorRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor not found"));
    }

    // Update Doctor details (and linked departments & patients)
    public Doctor updateDoctor(int id, Doctor updatedDoctor) {
        Doctor existing = getById(id);

        if (updatedDoctor.getDoctorName() != null)
            existing.setDoctorName(updatedDoctor.getDoctorName());

        if (updatedDoctor.getSpecialization() != null)
            existing.setSpecialization(updatedDoctor.getSpecialization());

        // Update One-to-Many departments
        if (updatedDoctor.getDepartments() != null && !updatedDoctor.getDepartments().isEmpty()) {
            existing.getDepartments().clear();
            for (Department dept : updatedDoctor.getDepartments()) {
                dept.setDoctor(existing); // set link
                existing.getDepartments().add(dept);
            }
        }

        // Update Many-to-Many patients
        if (updatedDoctor.getPatients() != null && !updatedDoctor.getPatients().isEmpty()) {
            List<Patient> patients = updatedDoctor.getPatients().stream()
                    .map(p -> patientRepo.findById(p.getPatientId())
                            .orElseThrow(() -> new ResponseStatusException(
                                    HttpStatus.NOT_FOUND, "Patient not found with ID: " + p.getPatientId())))
                    .collect(Collectors.toList());
            existing.setPatients(patients);
        }

        return doctorRepo.save(existing);
    }

    // Delete Doctor by ID
    public void deleteById(int id) {
        if (!doctorRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor ID not found");
        }
        doctorRepo.deleteById(id);
    }

    // Delete all Doctors
    public void deleteAll() {
        doctorRepo.deleteAll();
    }
}
