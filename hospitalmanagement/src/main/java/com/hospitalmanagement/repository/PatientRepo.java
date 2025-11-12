package com.hospitalmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalmanagement.entity.Patient;

public interface PatientRepo extends JpaRepository<Patient,Integer>{

	 List<Patient> findAllByDoctors_DoctorId(int doctorId);
	}

