package com.psawesome.testcodeproject.websocket.kafka.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.psawesome.testcodeproject.websocket.kafka.handler.dto.MyMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;
import reactor.kafka.receiver.ReceiverRecord;

/**
 * package: com.psawesome.testcodeproject.websocket.kafka.handler
 * author: PS
 * DATE: 2020-03-25 수요일 23:31
 */
@Component
public class ReactiveSocketHandler implements WebSocketHandler {

    private static final ObjectMapper mapper = new ObjectMapper();

    final KafkaService kafkaService;

    public ReactiveSocketHandler(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        return session.send(kafkaService.getTestTopicFlux()
        .map((ReceiverRecord<String, String> record) -> {
            MyMessage myMessage = new MyMessage("[Test] Add message", record.value());
            try {
                return mapper.writeValueAsString(myMessage);
            } catch (JsonProcessingException e) {
                return "error while serializing to JSON";
            }
        })
        .map(session::textMessage))
        .and(session.receive().map(WebSocketMessage::getPayloadAsText).log());
    }

}
