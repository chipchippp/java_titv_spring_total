package com.example.message_rabbitmq_consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @RabbitListener(queues = "messageQueue")
    public void consumeMessage(String content) {
        System.out.println("Message received: " + content);
    }
}
