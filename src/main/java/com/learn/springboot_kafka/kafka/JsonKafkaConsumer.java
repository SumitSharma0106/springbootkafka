package com.learn.springboot_kafka.kafka;

import com.learn.springboot_kafka.payload.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JsonKafkaConsumer {

    @KafkaListener(topics = "springboot-topic",groupId = "myGroup")
    public void consumeJsonMessage(User user){
        log.info("Json message received : {} ",user);
    }
}
