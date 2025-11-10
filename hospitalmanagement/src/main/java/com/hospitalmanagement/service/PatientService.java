package com.hospitalmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.hospitalmanagement.entity.Address;
import com.hospitalmanagement.entity.Doctor;
import com.hospitalmanagement.entity.Patient;
import com.hospitalmanagement.repository.AddressRepo;
import com.hospitalmanagement.repository.DoctorRepo;
import com.hospitalmanagement.repository.PatientRepo;

@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    //  Add Patient
    public Patient addPatient(Patient patient) {
        if (patient.getPatientName() == null || patient.getAge() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Patient name and age must be valid");
        }

        // Save address if available (One-to-One)
        if (patient.getAddress() != null) {
            Address savedAddress = addressRepo.save(patient.getAddress());
            patient.setAddress(savedAddress);
        }
//
//        // Handle Many-to-Many (Doctors)
        if (patient.getDoctors() != null && !patient.getDoctors().isEmpty()) {
            List<Doctor> doctors = patient.getDoctors().stream()
                    .map(d -> doctorRepo.findById(d.getDoctorId())
                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor not found with ID: " + d.getDoctorId())))
                    .toList();
            patient.setDoctors(doctors);
        }

        return patientRepo.save(patient);
    }

    // 📋 Get All Patients
    public List<Patient> getAll() {
        return patientRepo.findAll();
    }
//
//    //  Get Patient by ID
    public Patient getById(int id) {
        return patientRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found"));
    }
//
//    //  Update Patient
    public Patient updatePatient(int id, Patient updatedPatient) {
        Patient existing = getById(id);

        if (updatedPatient.getPatientName() != null)
            existing.setPatientName(updatedPatient.getPatientName());

        if (updatedPatient.getAge() > 0)
            existing.setAge(updatedPatient.getAge());

        // Update Address
        if (updatedPatient.getAddress() != null) {
            Address updatedAddress = updatedPatient.getAddress();
            if (existing.getAddress() != null) {
                existing.getAddress().setStreet(updatedAddress.getStreet());
                existing.getAddress().setCity(updatedAddress.getCity());
                existing.getAddress().setState(updatedAddress.getState());
                existing.getAddress().setPincode(updatedAddress.getPincode());
                addressRepo.save(existing.getAddress());
            } else {
                Address savedAddress = addressRepo.save(updatedAddress);
                existing.setAddress(savedAddress);
            }
        }

        // Update Doctor list (Many-to-Many)
        if (updatedPatient.getDoctors() != null && !updatedPatient.getDoctors().isEmpty()) {
            List<Doctor> doctors = updatedPatient.getDoctors().stream()
                    .map(d -> doctorRepo.findById(d.getDoctorId())
                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor not found with ID: " + d.getDoctorId())))
                    .toList();
            existing.setDoctors(doctors);
        }

        return patientRepo.save(existing);
    }
//
//    //  Delete Patient by ID
    public void deleteById(int id) {
        if (!patientRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient ID not found");
        }
        patientRepo.deleteById(id);
    }
//
//    //  Delete All Patients
    public void deleteAll() {
        patientRepo.deleteAll();
    }
}
