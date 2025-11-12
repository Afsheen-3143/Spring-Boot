package com.hospitalmanagement.service;

import com.hospitalmanagement.entity.Department;
import com.hospitalmanagement.entity.Doctor;
import com.hospitalmanagement.entity.Patient;
import com.hospitalmanagement.entity.Address;
import com.hospitalmanagement.repository.DepartmentRepo;
import com.hospitalmanagement.repository.DoctorRepo;
import com.hospitalmanagement.repository.PatientRepo;
import com.hospitalmanagement.repository.AddressRepo;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
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

    @Autowired
    private AddressRepo addressRepo;

    // Add Doctor (One-to-Many + Many-to-Many)
    @Transactional
    public Doctor addDoctor(Doctor doctor) {

        //  Handle Departments 
        if (doctor.getDepartments() != null && !doctor.getDepartments().isEmpty()) {
            List<Department> managedDepartments = new ArrayList<>();

            for (Department dept : doctor.getDepartments()) {
                if (dept.getDeptId() > 0) {
                    Department existingDept = departmentRepo.findById(dept.getDeptId())
                            .orElseThrow(() -> new ResponseStatusException(
                                    HttpStatus.NOT_FOUND,
                                    "Department not found with ID: " + dept.getDeptId()));
                    existingDept.setDoctor(doctor);
                    managedDepartments.add(existingDept);
                } else {
                    dept.setDoctor(doctor);
                    managedDepartments.add(dept);
                }
            }
            doctor.setDepartments(managedDepartments);
        } else {
            doctor.setDepartments(new ArrayList<>()); //  Prevent null list
        }

        // Handle Patients 
        if (doctor.getPatients() != null && !doctor.getPatients().isEmpty()) {
            List<Patient> managedPatients = new ArrayList<>();

            for (Patient patient : doctor.getPatients()) {
                Patient managedPatient;

                if (patient.getPatientId() > 0) {
                    managedPatient = patientRepo.findById(patient.getPatientId())
                            .orElseThrow(() -> new ResponseStatusException(
                                    HttpStatus.NOT_FOUND,
                                    "Patient not found with ID: " + patient.getPatientId()));
                } else {
                    if (patient.getAddress() != null) {
                        Address savedAddress = addressRepo.save(patient.getAddress());
                        patient.setAddress(savedAddress);
                    }
                    managedPatient = patientRepo.save(patient);
                }

                if (managedPatient.getDoctors() == null) {
                    managedPatient.setDoctors(new ArrayList<>());
                }
                managedPatient.getDoctors().add(doctor);

                managedPatients.add(managedPatient);
            }

            doctor.setPatients(managedPatients);
        } else {
            doctor.setPatients(new ArrayList<>()); //  Prevent null list
        }

        // Save the doctor safely
        Doctor savedDoctor = doctorRepo.save(doctor);

        // Refresh patient info (only if present)
        if (savedDoctor.getPatients() != null && !savedDoctor.getPatients().isEmpty()) {
            List<Patient> refreshedPatients = savedDoctor.getPatients().stream()
                    .map(p -> patientRepo.findById(p.getPatientId()).orElse(p))
                    .collect(Collectors.toList());
            savedDoctor.setPatients(refreshedPatients);
        }

        return savedDoctor;
    }

    // Get All Doctors
    public List<Doctor> getAll() {
        return doctorRepo.findAll();
    }

    // Get Doctor by ID
    public Doctor getById(int id) {
        return doctorRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor not found"));
    }

    // Update Doctor
    @Transactional
    public Doctor updateDoctor(int id, Doctor updatedDoctor) {
        Doctor existing = getById(id);

        if (updatedDoctor.getDoctorName() != null)
            existing.setDoctorName(updatedDoctor.getDoctorName());

        if (updatedDoctor.getSpecialization() != null)
            existing.setSpecialization(updatedDoctor.getSpecialization());

        // Update Departments
        if (updatedDoctor.getDepartments() != null && !updatedDoctor.getDepartments().isEmpty()) {
            existing.getDepartments().clear();
            for (Department dept : updatedDoctor.getDepartments()) {
                dept.setDoctor(existing);
                existing.getDepartments().add(dept);
            }
        }

        // Update Patients
        if (updatedDoctor.getPatients() != null && !updatedDoctor.getPatients().isEmpty()) {
            List<Patient> patients = updatedDoctor.getPatients().stream().map(p -> {
                if (p.getPatientId() > 0) {
                    return patientRepo.findById(p.getPatientId())
                            .orElseThrow(() -> new ResponseStatusException(
                                    HttpStatus.NOT_FOUND, "Patient not found with ID: " + p.getPatientId()));
                } else {
                    if (p.getAddress() != null) {
                        Address savedAddress = addressRepo.save(p.getAddress());
                        p.setAddress(savedAddress);
                    }
                    return patientRepo.save(p);
                }
            }).collect(Collectors.toList());
            existing.setPatients(patients);
        }

        Doctor savedDoctor = doctorRepo.save(existing);

        // Refresh patients to include full details
        List<Patient> refreshedPatients = savedDoctor.getPatients().stream()
                .map(p -> patientRepo.findById(p.getPatientId()).orElse(p))
                .collect(Collectors.toList());
        savedDoctor.setPatients(refreshedPatients);

        return savedDoctor;
    }

    // Delete Doctor by ID
    public void deleteById(int id) {
        if (!doctorRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor ID not found");
        }
        doctorRepo.deleteById(id);
    }

    // Delete All Doctors
    public void deleteAll() {
        doctorRepo.deleteAll();
    }
}
