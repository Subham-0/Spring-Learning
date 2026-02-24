package com.subham.kafka_consumer_example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



@Service
public class KafkaMessageListener {
    Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "topic-1",groupId = "group-1")
    public void consumer(String message){
        log.info("consumer consume the message {}",message);
    }
}
