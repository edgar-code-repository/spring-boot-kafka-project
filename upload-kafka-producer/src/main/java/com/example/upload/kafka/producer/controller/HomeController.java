package com.example.upload.kafka.producer.controller;

import com.example.upload.kafka.producer.form.KafkaForm;
import com.example.upload.kafka.producer.services.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping("/")
    public String home(Model model) {
        logger.debug("[HomeController][home][START]");

        KafkaForm kafkaForm = new KafkaForm();
        model.addAttribute("kafkaForm", kafkaForm);

        logger.debug("[HomeController][home][END]");
        return "home";
    }

    @RequestMapping("/publish")
    public String sendMessageToKafka(@ModelAttribute("uploadForm") KafkaForm kafkaForm) {
        logger.info("[HomeController][sendMessageToKafka][message: " + kafkaForm.getMessage() + "]");
        this.kafkaProducer.sendMessage(kafkaForm.getMessage());

        logger.info("[HomeController][sendMessageToKafka][END]");
        return "result";
    }

}
