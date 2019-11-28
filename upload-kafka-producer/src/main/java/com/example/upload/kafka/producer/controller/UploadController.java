package com.example.upload.kafka.producer.controller;

import com.example.upload.kafka.producer.form.KafkaForm;
import com.example.upload.kafka.producer.model.FileUpload;
import com.example.upload.kafka.producer.repository.FileUploadRepository;
import com.example.upload.kafka.producer.services.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UploadController {
    static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private FileUploadRepository fileUploadRepository;

    @Value("${upload.directory}")
    private String uploadDirectory;

    public UploadController() {
    }

    @RequestMapping("/uploadFile")
    public String uploadFileHandler(Model model) {
        logger.info("[UploadController][uploadFileHandler][START]");

        KafkaForm kafkaForm = new KafkaForm();
        model.addAttribute("kafkaForm", kafkaForm);

        logger.info("[UploadController][uploadFileHandler][END]");
        return "uploadFile";
    }

    @PostMapping("/uploadFile")
    public String uploadFilePost(HttpServletRequest request, Model model, @ModelAttribute("kafkaForm") KafkaForm kafkaForm) {
        logger.info("[UploadController][uploadFilePost][START]");
        logger.info("[UploadController][uploadFilePost][kafkaForm: " + kafkaForm + "]");

        String description = kafkaForm.getDescription();
        //String uploadRootPath = request.getServletContext().getRealPath("upload");
        String uploadRootPath = uploadDirectory;
        MultipartFile fileData = kafkaForm.getFileData();
        FileUpload fileUpload = new FileUpload();
        boolean flagUpload = false;
        String name = "";
        String message = "";

        File uploadRootDir = new File(uploadRootPath);
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }

        if (fileData != null) {
            name = fileData.getOriginalFilename();

            logger.info("[UploadController][uploadFilePost][fileData not null]");
            logger.info("[UploadController][uploadFilePost][file name: " + name + "]");

            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String dateString = format.format(new Date());

            logger.info("[UploadController][uploadFilePost][dateString: " + dateString + "]");

            if (name != null && name.length() > 0) {
                try {
                    File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + dateString + "_" + name);
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                    stream.write(fileData.getBytes());
                    stream.close();

                    logger.info("[UploadController][uploadFilePost][file was uploaded: " + name + "]");

                    fileUpload.setOriginalName(name);
                    fileUpload.setFilename(dateString + "_" + name);
                    fileUpload.setUploadPath(uploadRootDir.getAbsolutePath());
                    fileUpload.setUploadDate(new Date());
                    fileUpload.setDescription(description);
                    fileUpload.setState("P"); //Processing

                    fileUpload = fileUploadRepository.save(fileUpload);

                    flagUpload = true;

                    logger.info("[UploadController][uploadFilePost][file was saved into db: " + fileUpload.toString() + "]");
                } catch (Exception e) {
                    logger.info("[UploadController][uploadFilePost][error: " + e.toString() + "]");
                }
            }
        }

        if (flagUpload) {
            message = "File " + name + " was uploaded successfully!!!";
            //this.kafkaProducer.sendMessage(message);
            this.kafkaProducer.processFile(fileUpload.getFileUploadId());
        }
        else {
            message = "File was NOT uploaded!!!";
        }

        model.addAttribute("message", message);

        logger.info("[UploadController][uploadFilePost][END]");
        return "result";
    }

}
