package com.example.upload.kafka.producer.repository;

import com.example.upload.kafka.producer.model.FileUpload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadRepository extends JpaRepository<FileUpload, Integer> {
}
