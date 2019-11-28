package com.example.upload.kafka.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(id="kafka-consumer-example", topics="kafka-message-example")
    public void consumeKafkaMessage(String message) {
        logger.info("[KafkaConsumer][consumeKafkaMessage][message consumed: " + message + "]");
    }

    @KafkaListener(id="kafka-process-file", topics="kafka-process-file")
    public void processFileUploaded(String fileUploadId) {
        logger.info("[KafkaConsumer][processFileUploaded][fileUploadId: " + fileUploadId + "]");
    }

}
