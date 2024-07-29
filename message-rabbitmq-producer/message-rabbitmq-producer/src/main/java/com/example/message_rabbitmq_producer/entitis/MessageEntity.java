package com.example.message_rabbitmq_producer.entitis;

import jakarta.persistence.Entity;

public class MessageEntity {
    private String message;

    public MessageEntity() {
    }

    public MessageEntity(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
