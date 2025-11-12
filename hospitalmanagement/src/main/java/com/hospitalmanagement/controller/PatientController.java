package com.hospitalmanagement.controller;

import com.hospitalmanagement.entity.Patient;
import com.hospitalmanagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "*")
public class PatientController {

    @Autowired
    private PatientService patientService;

    //  Add Patient
    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.addPatient(patient));
    }

    //  Get All Patients
    @GetMapping
    public ResponseEntity<List<Patient>> getAll() {
        return ResponseEntity.ok(patientService.getAll());
    }

    //  Get Patient by ID
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getById(@PathVariable int id) {
        return ResponseEntity.ok(patientService.getById(id));
    }

    //  Update Patient
    @PutMapping("/{id}")
    public ResponseEntity<Patient> update(@PathVariable int id, @RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.updatePatient(id, patient));
    }

    //  Delete Patient by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        patientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //  Delete All Patients
    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        patientService.deleteAll();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/doctors/{doctorId}/patients")
    public List<Patient> getPatientsByDoctor(@PathVariable int doctorId) {
        return patientService.getPatientsByDoctorId(doctorId);
    }

}
