package LearningSystem.LS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import LearningSystem.LS.model.SubjectArea;
import LearningSystem.LS.service.SubjectareaService;

@RestController
@RequestMapping("/subject")
public class SubjectareaController {

	@Autowired
	private SubjectareaService subjectservice;
	
	@PostMapping("/add")
	public SubjectArea addsubject(@RequestBody SubjectArea subject) {
		return subjectservice.addsubjectarea(subject);
	}
	
	@GetMapping("/getAll")
	public List<SubjectArea> getAllsubjects() {
		return subjectservice.getAllSubjects();
	}
	
	@GetMapping("/getbyId/{Id}")
	public SubjectArea getbyId(@PathVariable int Id) {
		return subjectservice.getSubject(Id);
	}
	@PutMapping("/update/{Id}")
	public SubjectArea updateSubject(@PathVariable int Id,@RequestBody SubjectArea subject) {
		return subjectservice.updateSubject(Id, subject);
	}
	@DeleteMapping("/deletebyId/{Id}")
	public String deleteSubject(@PathVariable int Id) {
		 subjectservice.deleteSubject(Id);
		 return "deleted successfully";
	}
	@DeleteMapping("/deleteAll")
	public void deleteAllsubjects() {
		subjectservice.deleteAllsubjects();
	}
}
