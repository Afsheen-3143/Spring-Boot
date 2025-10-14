package annotation.Qualifier;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@ComponentScan("AnnotationConfig.Qualifier")
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("AnnotationConfig.Qualifier");

        Zoo zoo = context.getBean(Zoo.class);
        zoo.sound(); // Output: Meow!

        context.close();
    }
}
