package annotation.Value;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ValueMain {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ValueMain.class, args);
        ValueannotDemo demo = context.getBean(ValueannotDemo.class);
        demo.display();
    }
}
