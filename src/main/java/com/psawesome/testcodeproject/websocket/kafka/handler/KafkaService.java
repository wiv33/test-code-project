package com.psawesome.testcodeproject.websocket.kafka.handler;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.kafka.receiver.ReceiverRecord;

/**
 * package: com.psawesome.testcodeproject.websocket.kafka.handler
 * author: PS
 * DATE: 2020-03-26 목요일 21:29
 */
@Component
public interface KafkaService {

    Flux<ReceiverRecord<String, String>> getTestTopicFlux();
}
