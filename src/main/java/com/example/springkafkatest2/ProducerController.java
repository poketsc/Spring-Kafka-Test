package com.example.springkafkatest2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @RequestMapping("/publish")
    public String publish(String message) {

        kafkaProducerService.send(message);

        return "published a message : " + message;
    }

    @RequestMapping("/publish2")
    public String publishWithCallback(String message) {

        kafkaProducerService.sendWithCallback(message);

        return "published a message : " + message;
    }

    @RequestMapping("/publish3")
    public String publishJson(MyMessage message) {

        kafkaProducerService.sendJson(message);

        return message.getName() + " , " + message.getMessage();
    }
}
