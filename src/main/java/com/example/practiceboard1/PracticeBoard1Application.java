package com.example.practiceboard1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class PracticeBoard1Application {

    public static void main(String[] args) {
        SpringApplication.run(PracticeBoard1Application.class, args);
    }

}
