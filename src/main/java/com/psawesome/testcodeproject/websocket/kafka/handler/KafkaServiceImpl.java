package com.psawesome.testcodeproject.websocket.kafka.handler;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;
import reactor.kafka.receiver.ReceiverRecord;

import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

/**
 * package: com.psawesome.testcodeproject.websocket.kafka.handler
 * author: PS
 * DATE: 2020-03-28 토요일 22:27
 */
@Service
public class KafkaServiceImpl implements KafkaService {

    private Flux<ReceiverRecord<String, String>> testTopicStream;

    public KafkaServiceImpl() {
        try {
            Properties properties = PropertiesLoaderUtils.loadAllProperties("ccloud.properties");

            properties.put(ConsumerConfig.CLIENT_ID_CONFIG, "reactive-consumer");
            properties.put(ConsumerConfig.GROUP_ID_CONFIG, "sample-group");
            properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
            properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
            properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

            ReceiverOptions<String, String> receive = ReceiverOptions.create(properties);

            testTopicStream = createTopicCache(receive, "psawesome-topic");
        } catch (IOException e) {
            throw new RuntimeException("occurred Error");
        }
    }

    private <T, G> Flux<ReceiverRecord<T, G>> createTopicCache(ReceiverOptions<T, G> receive, String topicName) {
        ReceiverOptions<T, G> options = receive.subscription(Collections.singleton(topicName));
        return KafkaReceiver.create(options).receive().cache();
    }

    @Override
    public Flux<ReceiverRecord<String, String>> getTestTopicFlux() {
        return testTopicStream;
    }

}
