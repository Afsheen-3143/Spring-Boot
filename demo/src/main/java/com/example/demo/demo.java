package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class demo {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(demo.class, args);
        
        int port = context.getBean(WebServerApplicationContext.class)
                          .getWebServer()
                          .getPort();
        System.out.println("Application is running on port: " + port);
    }
}
