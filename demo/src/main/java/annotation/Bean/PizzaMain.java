package annotation.Bean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.DemoApplication;
@SpringBootApplication
public class PizzaMain {
	public static void main(String[] args) {
		SpringApplication.run(PizzaMain.class, args);
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(PizzaConfig.class);
		Vegpizza veg=context.getBean(Vegpizza.class);
		veg.getpizza();
		 Nonvegpizza nonveg = context.getBean(Nonvegpizza.class);
	        nonveg.getpizza();
	        context.close();
				
	}

}
