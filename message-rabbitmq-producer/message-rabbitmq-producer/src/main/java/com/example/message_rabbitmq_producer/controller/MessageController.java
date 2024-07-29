package com.example.message_rabbitmq_producer.controller;

import com.example.message_rabbitmq_producer.entitis.MessageEntity;
import com.example.message_rabbitmq_producer.servies.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {
    private final MessagingService messagingService;

    @Autowired
    public MessageController(MessagingService messagingService) {
        this.messagingService = messagingService;
    }

    @PostMapping("/message")
    public void sendMessage(@RequestBody MessageEntity message) {
        messagingService.sendMessage(message.getMessage());
    }
}
