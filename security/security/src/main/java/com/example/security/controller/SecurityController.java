package com.example.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.entity.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/students")
public class SecurityController {

	@GetMapping("/")
	public String greet() {
		return "welcome to new webpage";
	}
	private List<Student>students=new ArrayList<>(List.of(
			new Student(1,"Afsheen",90),
			new Student (2,"Teja",100)));
	
	@GetMapping("/get")
	public List<Student> getstudents() {
		return students;
	}
	@GetMapping("/csrf")
	public CsrfToken getcsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
	
	@PostMapping("/add")
	public Student addstudents(@RequestBody Student student) {
		students.add(student);
		return student;
	}
}
