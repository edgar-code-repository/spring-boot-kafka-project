package com.example.upload.kafka.producer.form;

import org.springframework.web.multipart.MultipartFile;

public class KafkaForm {

    private String description;
    private MultipartFile fileData;
    private String message;

    public KafkaForm() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getFileData() {
        return fileData;
    }

    public void setFileData(MultipartFile fileData) {
        this.fileData = fileData;
    }

    @Override
    public String toString() {
        return "KafkaForm {" +
                "description='" + description + '\'' +
                ", fileData=" + fileData +
                ", message='" + message + '\'' +
                '}';
    }

}
