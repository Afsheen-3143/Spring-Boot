package annotation.propertySource;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication
public class PropertyMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PropertyMain.class, args);
	 PropertyDemo demo=context.getBean(PropertyDemo.class);
	 System.out.println(demo.getHost());
	 System.out.println(demo.getUsername());
	 System.out.println(demo.getPassword());
	 System.out.println(demo.getPort());
	
		

	}

}
