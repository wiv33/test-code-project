package com.psawesome.testcodeproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Profile("kafka")
public class TestCodeProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestCodeProjectApplication.class, args);
    }

}
