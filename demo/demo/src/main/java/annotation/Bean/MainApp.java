package annotation.Bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		Student student=context.getBean(Student.class);
		System.out.println(student.toString());
	}

}
