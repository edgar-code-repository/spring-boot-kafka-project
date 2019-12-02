package com.example.upload.kafka.consumer.service;

import com.example.upload.kafka.consumer.mapper.FileUploadMapper;
import com.example.upload.kafka.consumer.to.FileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private FileUploadMapper fileUploadMapper;

    @KafkaListener(id="kafka-consumer-example", topics="kafka-message-example")
    public void consumeKafkaMessage(String message) {
        logger.info("[KafkaConsumer][consumeKafkaMessage][message consumed: " + message + "]");
    }

    @KafkaListener(id="kafka-process-file", topics="kafka-process-file")
    public void processFileUploaded(String fileUploadId) {
        logger.info("[KafkaConsumer][processFileUploaded][fileUploadId: " + fileUploadId + "]");

        FileUpload fileUploaded = fileUploadMapper.getFileUploaded(Integer.parseInt(fileUploadId));
        logger.info("[KafkaConsumer][processFileUploaded][fileUploaded name: " + fileUploaded.getFilename() + "]");
        logger.info("[KafkaConsumer][processFileUploaded][The file retrieved from database should be processed]");

        
    }

}
