package annotation.Scope;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SingleMain {

	public static void main(String[] args) {
	ConfigurableApplicationContext context= SpringApplication.run(SingleMain.class, args);
	Singleton s=context.getBean(Singleton.class);
	System.out.println(s.hashCode());
	Singleton s1=context.getBean(Singleton.class);
	System.out.println(s.hashCode());
	Singleton s2=context.getBean(Singleton.class);
	System.out.println(s.hashCode());
	Prototype p=context.getBean(Prototype.class);
	Prototype p1=context.getBean(Prototype.class);
	


	}

}
