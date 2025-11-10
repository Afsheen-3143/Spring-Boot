package com.hospitalmanagement.controller;

import com.hospitalmanagement.entity.Doctor;
import com.hospitalmanagement.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/doctors")
@CrossOrigin(origins = "*")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    //  Add Doctor
    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorService.addDoctor(doctor));
    }

    //  Get All Doctors
    @GetMapping
    public ResponseEntity<List<Doctor>> getAll() {
        return ResponseEntity.ok(doctorService.getAll());
    }

    //  Get Doctor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getById(@PathVariable int id) {
        return ResponseEntity.ok(doctorService.getById(id));
    }

    //  Update Doctor
    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable int id, @RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorService.updateDoctor(id, doctor));
    }

    //  Delete Doctor by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        doctorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //  Delete All Doctors
    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        doctorService.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
