package com.psawesome.testcodeproject;

import com.psawesome.testcodeproject.websocket.kafka.handler.KafkaServiceImpl;
import com.psawesome.testcodeproject.websocket.kafka.handler.ReactiveSocketHandler;
import com.psawesome.testcodeproject.websocket.kafka.handler.config.ReactiveWebSocketConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Profile("kafka")
@ComponentScan(basePackageClasses = {ReactiveWebSocketConfiguration.class, KafkaServiceImpl.class, ReactiveSocketHandler.class})
public class TestCodeProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestCodeProjectApplication.class, args);
    }

}
