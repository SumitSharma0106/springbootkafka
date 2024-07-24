package com.learn.springboot_kafka.kafka;

import com.learn.springboot_kafka.payload.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JsonKafkaProducer {

    @Autowired
    private KafkaTemplate<String, User> userKafkaTemplate;

    public void sendUserData(User user){
        log.info("User message : {} ",user);
        Message<User> userMessage= MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC,"springboot-topic")
                .build();
        userKafkaTemplate.send(userMessage);
    }
}
