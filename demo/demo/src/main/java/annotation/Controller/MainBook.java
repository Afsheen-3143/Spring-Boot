package annotation.Controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import annotation.Lazy.Main;

@SpringBootApplication
public class MainBook {
	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(MainBook.class,args);
		
	}

}
