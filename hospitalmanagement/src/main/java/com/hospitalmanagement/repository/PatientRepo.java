package com.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalmanagement.entity.Patient;

public interface PatientRepo extends JpaRepository<Patient,Integer>{


}
