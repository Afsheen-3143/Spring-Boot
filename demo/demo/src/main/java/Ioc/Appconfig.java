package Ioc;

import org.springframework.context.annotation.Bean;

public class Appconfig {
	@Bean
	public Course course () {
		return new Course();
	}
	@Bean
	public Student student() {
        return new Student(course());
	}

}
