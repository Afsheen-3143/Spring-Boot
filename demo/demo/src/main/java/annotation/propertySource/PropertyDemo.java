package annotation.propertySource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class PropertyDemo {

    @Value("${gmail.host}")
    private String host;

    @Value("${gmail.port}")
    private int port;

    @Value("${gmail.username}")
    private String username;

    @Value("${gmail.password}")
    private String password;

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

    

}
