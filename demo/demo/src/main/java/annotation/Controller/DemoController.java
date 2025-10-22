package annotation.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
	@RequestMapping("/demo")
	public void demo() {
		System.out.println("demo controller");
	}
	@RequestMapping("/spring")
	public String spring() {
		return "Spring framework";
	}

}
