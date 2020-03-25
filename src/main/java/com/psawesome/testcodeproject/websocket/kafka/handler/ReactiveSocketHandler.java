package com.psawesome.testcodeproject.websocket.kafka.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

/**
 * package: com.psawesome.testcodeproject.websocket.kafka.handler
 * author: PS
 * DATE: 2020-03-25 수요일 23:31
 */
@Component
public class ReactiveSocketHandler implements WebSocketHandler {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    KafkaService kafkaService;

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        return null;
    }
}
