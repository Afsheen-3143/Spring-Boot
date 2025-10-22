package annotation.Qualifier;

import org.springframework.stereotype.Component;

@Component
public class Cat implements Animal {

	@Override
	public void makesound() {
		System.out.println("cat makes sound");		
	}

}
