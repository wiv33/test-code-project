package com.psawesome.testcodeproject.websocket.kafka.handler.example;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Properties;

/**
 * package: com.psawesome.testcodeproject.websocket.kafka.handler.example
 * author: PS
 * DATE: 2020-03-29 일요일 22:42
 */
@Slf4j
public class KafkaExample {
    private final String topic;
    private final Properties props;

    public KafkaExample(String brokers, String username, String password) {
        this.topic = username + "awesome-topic";

        String jaasTemplate = "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"%s\" password=\"%s\";";
        String jaasCfg = String.format(jaasTemplate, username, password);

        String serializer = StringSerializer.class.getName();
        String deserializer = StringDeserializer.class.getName();
        props = new Properties();
        props.put("bootstrap.servers", brokers);
        props.put("group.id", username + "-consumer");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "earliest");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", deserializer);
        props.put("value.deserializer", deserializer);
        props.put("key.serializer", serializer);
        props.put("value.serializer", serializer);
        props.put("security.protocol", "SASL_SSL");
        props.put("sasl.mechanism", "SCRAM-SHA-256");
        props.put("sasl.jaas.config", jaasCfg);
    }

    public void consume() {
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList(topic));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(3));
            for (ConsumerRecord<String, String> record : records) {
                log.info("{} [{}] offset={}, key={}, value=\"{}\"\n",
                        record.topic(), record.partition(),
                        record.offset(), record.key(), record.value());
            }
        }
    }

    public void produce() {
        Thread one = new Thread(() -> {
            try {
                Producer<String, String> producer = new KafkaProducer<>(props);
                int i = 0;
                while(true) {
                    LocalDateTime d = LocalDateTime.now();
                    producer.send(new ProducerRecord<>(topic, Integer.toString(i), d.toString()), (metadata, exception) -> {
                        System.out.println(metadata);
                        System.out.println("metadata = " + metadata);
                    });
                    Thread.sleep(3000);
                    i++;
                }
            } catch (InterruptedException v) {
                log.error(v.getMessage());
            }
        });
        one.start();
    }

    public static void main(String[] args) {
        String brokers = "localhost:9092"; //System.getenv("CLOUDKARAFKA_BROKERS");
        String username = "ps";//System.getenv("CLOUDKARAFKA_USERNAME");
        String password = "ps-secret"; //System.getenv("CLOUDKARAFKA_PASSWORD");
        KafkaExample c = new KafkaExample(brokers, username, password);
        c.produce();
        c.consume();
    }
}
