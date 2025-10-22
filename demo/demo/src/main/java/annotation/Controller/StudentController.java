package annotation.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	 @GetMapping("/student")
	    public Student getStudent() {
	        return new Student("Afsheen", 1, 45);
	    }
	

}
