package annotation.Value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class ValueannotDemo {
//	@Value("Afsheen")
//	private String name;
//	@Value("23")
//	private int id;
//	
//	public void show() {
//		System.out.println("Name"+name+"id"+id);
	
//	using property file
	
	

	    @Value("${gmail.host}")
	    private String host;

	    @Value("${gmail.port}")
	    private int port;

	    @Value("${gmail.username}")
	    private String username;

	    @Value("${gmail.password}")
	    private String password;

	    public void display() {
	        System.out.println("Gmail Host: " + host);
	        System.out.println("Port: " + port);
	        System.out.println("Username: " + username);
	        System.out.println("Password: " + password);
	    }
	}
