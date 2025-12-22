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

import LearningSystem.LS.model.Course;
import LearningSystem.LS.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseservice;
	
	@PostMapping("/add/{subjectId}")
	public Course addcourses(@PathVariable int subjectId,@RequestBody Course course) {
		return courseservice.addcourse(subjectId, course);
	}
	
	@PutMapping("/update/{courseId}")
	public Course updatecourse(@PathVariable int courseId, @RequestBody Course course) {
		return courseservice.updatecourse(courseId, course);
	}
	
	@GetMapping("/getAll")
	public List<Course> getAllcourses() {
		return courseservice.getAllcourses();
	}
	@GetMapping("/getbyId/{courseId}")
	public Course getById(@PathVariable int courseId) {
		return courseservice.getCoursesById(courseId);
	}
	@DeleteMapping("/deletebyId/{courseId}")
	public void deleteById(@PathVariable int courseId) {
		 courseservice.deletecourse(courseId);
	}
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		courseservice.deleteAllCourses();
	}

}
