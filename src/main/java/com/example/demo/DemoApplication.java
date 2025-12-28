package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.WebApplicationType;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(DemoApplication.class);

        // 🔥 CRITICAL FIX FOR TESTS
        // If running from TestNG / Maven tests, DO NOT start Tomcat
        if (System.getProperty("test.env") != null) {
            app.setWebApplicationType(WebApplicationType.NONE);
        }

        app.run(args);
    }
}
