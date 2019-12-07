package com.example.upload.kafka.consumer.service;

import com.example.upload.kafka.consumer.mapper.FileUploadMapper;
import com.example.upload.kafka.consumer.to.FileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

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
    public void processFileUploaded(String fileUploadId) throws InterruptedException {
        logger.info("[KafkaConsumer][processFileUploaded][fileUploadId: " + fileUploadId + "]");

        FileUpload fileUploaded = fileUploadMapper.getFileUploaded(Integer.parseInt(fileUploadId));
        logger.info("[KafkaConsumer][processFileUploaded][fileUploaded: " + fileUploaded.toString() + "]");

        DateTimeFormatter myFormatObject = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        logger.info("[KafkaConsumer][processFileUploaded][Date previous sleep: " + LocalDateTime.now().format(myFormatObject) + "]");
        TimeUnit.SECONDS.sleep(15);
        logger.info("[KafkaConsumer][processFileUploaded][Date after sleep: " + LocalDateTime.now().format(myFormatObject) + "]");

        logger.info("[KafkaConsumer][processFileUploaded][Updating State]");
        FileUpload fileUpdated = new FileUpload();
        fileUpdated.setFileUploadId(Integer.parseInt(fileUploadId));
        fileUpdated.setState("C");
        fileUploadMapper.update(fileUpdated);

        fileUpdated = fileUploadMapper.getFileUploaded(Integer.parseInt(fileUploadId));

        if (fileUpdated != null) {
            logger.info("[KafkaConsumer][processFileUploaded][fileUpdated: " + fileUpdated.toString() + "]");
            logger.info("[KafkaConsumer][processFileUploaded][The file was processed]");
        }
        else {
            logger.info("[KafkaConsumer][processFileUploaded][fileUpdated NULL]");
        }

    }

}
