package com.learn.springboot_kafka.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "springboot-topic",groupId = "myGroup")
    public void consumeMessage(String message){
        log.info("Message received from producer : {} ",message);
    }
}
