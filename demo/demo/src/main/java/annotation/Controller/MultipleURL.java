package annotation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class MultipleURL {
	@RequestMapping({"/home", "/index", "/main"})
	public String home() {
		return "this is home page";
		
	}

}
