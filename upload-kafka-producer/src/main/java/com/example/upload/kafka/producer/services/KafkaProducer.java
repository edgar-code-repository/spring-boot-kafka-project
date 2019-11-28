package com.example.upload.kafka.producer.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    private static final String TOPIC = "kafka-message-example";
    private static final String PROCESS_FILE_TOPIC = "kafka-process-file";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message) {
        logger.info("[KafkaProducer][sendMessage][message: " + message + "]");
        this.kafkaTemplate.send(TOPIC, message);
    }

    public void processFile(Integer fileUploadId) {
        logger.info("[KafkaProducer][sendMessage][fileUploadId: " + fileUploadId + "]");
        this.kafkaTemplate.send(PROCESS_FILE_TOPIC, String.valueOf(fileUploadId));
    }


}
