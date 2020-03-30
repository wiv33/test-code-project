package com.psawesome.testcodeproject.websocket.kafka.handler;

import com.psawesome.testcodeproject.TestCodeProjectApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * package: com.psawesome.testcodeproject.websocket.kafka.handler
 * author: PS
 * DATE: 2020-03-25 수요일 23:35
 */
@SpringBootTest(classes = TestCodeProjectApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class ReactiveSocketHandlerTest {

    @Autowired
    KafkaService kafkaService;

    @Autowired
    ReactiveSocketHandler handler;


    @Test
    void testInitService() {
        Assertions.assertAll(
                () -> Assertions.assertNotNull(kafkaService),
                () -> Assertions.assertNotNull(handler)
        );
    }

    @Test
    @DisplayName("")
    void testWebsocketHandlerSendMessage() {
    }
}