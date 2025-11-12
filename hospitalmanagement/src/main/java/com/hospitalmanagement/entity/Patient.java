package com.hospitalmanagement.entity;



	import jakarta.persistence.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

	@Entity
	public class Patient {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int patientId;

	    private String patientName;
	    private int age;

	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "address_id")
	    @JsonManagedReference
	    private Address address;

	    @ManyToMany(mappedBy = "patients",cascade = CascadeType.ALL)
	    @JsonBackReference
	    private List<Doctor> doctors;

	    public int getPatientId() {
	        return patientId;
	    }

	    public void setPatientId(int patientId) {
	        this.patientId = patientId;
	    }

	    public String getPatientName() {
	        return patientName;
	    }

	    public void setPatientName(String patientName) {
	        this.patientName = patientName;
	    }

	    public int getAge() {
	        return age;
	    }

	    public void setAge(int age) {
	        this.age = age;
	    }

	    public Address getAddress() {
	        return address;
	    }

	    public void setAddress(Address address) {
	        this.address = address;
	    }

	    public java.util.List<Doctor> getDoctors() {
	        return doctors;
	    }

	    public void setDoctors(java.util.List<Doctor> doctors) {
	        this.doctors = doctors;
	    }
	}



