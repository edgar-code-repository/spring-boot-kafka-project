package com.example.upload.kafka.consumer.to;

import java.util.Date;

public class FileUpload {
    private Integer fileUploadId;

    private String originalName;
    private String filename;
    private String description;
    private String uploadPath;
    private Date uploadDate;
    private String state;

    public FileUpload() {
    }

    public String toString() {
        return "FileUpload {" +
                "fileUploadId=" + fileUploadId +
                ", originalName='" + originalName + '\'' +
                ", filename='" + filename + '\'' +
                ", description='" + description + '\'' +
                ", uploadPath='" + uploadPath + '\'' +
                ", uploadDate=" + uploadDate +
                ", state='" + state + '\'' +
                '}';
    }

    public Integer getFileUploadId() {
        return fileUploadId;
    }

    public void setFileUploadId(Integer fileUploadId) {
        this.fileUploadId = fileUploadId;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
