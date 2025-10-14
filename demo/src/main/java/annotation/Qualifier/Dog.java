package annotation.Qualifier;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {

	@Override
	public void makesound() {
		System.out.println("Dog makes sound");
		
	}
	

}
