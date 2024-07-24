package com.learn.springboot_kafka.controller;

import com.learn.springboot_kafka.kafka.JsonKafkaProducer;
import com.learn.springboot_kafka.kafka.KafkaProducer;
import com.learn.springboot_kafka.payload.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka/v1")
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;

    @GetMapping("/{message}")
    public ResponseEntity<String> publishMessage(@PathVariable String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message send to the topic");
    }

    @GetMapping("/json")
    public ResponseEntity<String> publishUserMessage(@RequestBody User user){
        jsonKafkaProducer.sendUserData(user);
        return ResponseEntity.ok("Message send to kafka json topic");
    }


}
